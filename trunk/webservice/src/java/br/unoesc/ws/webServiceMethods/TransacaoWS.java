package br.unoesc.ws.webServiceMethods;

import br.unoesc.ws.configs.CodigosRetorno;
import br.unoesc.ws.exceptions.CPFInvalidoException;
import br.unoesc.ws.exceptions.CerealNotFoundException;
import br.unoesc.ws.exceptions.CidadeNotFoundException;
import br.unoesc.ws.exceptions.EmpresaNaoAutorizadaException;
import br.unoesc.ws.exceptions.ParametroNuloException;
import br.unoesc.ws.exceptions.ProdutorNotFoundException;
import br.unoesc.ws.exceptions.SalvarException;
import br.unoesc.ws.exceptions.SenhaIncorretaException;
import br.unoesc.ws.exceptions.TransacaoNotFoundException;
import br.unoesc.ws.model.MultiplicadorEstadoSafra;
import br.unoesc.ws.model.Produtor;
import br.unoesc.ws.model.Transacao;
import br.unoesc.ws.objectFactory.TransacaoFactory;
import br.unoesc.ws.model.TransacaoCredito;
import br.unoesc.ws.model.TransacaoDebito;
import br.unoesc.ws.objectFactory.ProdutorFactory;
import br.unoesc.ws.serviceModel.CerealServiceImpl;
import br.unoesc.ws.serviceModel.EstadoServiceImpl;
import br.unoesc.ws.serviceModel.MultiplicadorEstadoSafraServiceImpl;
import br.unoesc.ws.serviceModel.ProdutorServiceImpl;
import br.unoesc.ws.serviceModel.TransacaoCreditoServiceImpl;
import br.unoesc.ws.serviceModel.TransacaoDebitoServiceImpl;
import br.unoesc.ws.webModelEntrada.ExcluirTransacaoSampleModel;
import br.unoesc.ws.webModelEntrada.ProdutorSampleModel;
import br.unoesc.ws.webModelEntrada.IncluirTransacaoSampleModel;
import br.unoesc.ws.webModelRetorno.ObjetoRetorno;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * classe de publicação dos métodos disponíveis para o WS
 * @author vitor
 */
@WebService
public class TransacaoWS {

    /** metodo usado para a inclusao de creditos(quando da venda de semente
     *  com controle de royalties). gera o boleto para pagamento ao salvar
     * o objeto @see TransacaoCredito
     *
     * @param t
     *@return  @see ObjetoRetorno
     */
    @WebMethod
    public ObjetoRetorno incluirCredito(@WebParam(name = "transacaoCredito") IncluirTransacaoSampleModel t) {

        TransacaoCreditoServiceImpl transacaoService = new TransacaoCreditoServiceImpl();
        EstadoServiceImpl es=new EstadoServiceImpl();
        CerealServiceImpl c=new CerealServiceImpl();
        ObjetoRetorno retorno;

        TransacaoCredito tc = null;

        try {
            tc = (TransacaoCredito) new TransacaoFactory().criarTransacaoParaInclusao(t, new TransacaoCredito());
//    [-------------------------------]
            MultiplicadorEstadoSafraServiceImpl mi=new MultiplicadorEstadoSafraServiceImpl();
            MultiplicadorEstadoSafra m=mi.getMultiplicadorSafraCorrentePorEstado(c.getCerealById(t.getCodCereal()),es.getById(t.getIdEstadoPlantio()));
            tc.setMultiplicador(m);
//    [-------------------------------]
        } catch (CerealNotFoundException ex) {
            retorno = new ObjetoRetorno(CodigosRetorno.CODIGO_CEREAL_NAO_ENCONTRADO, ex.getMessage(), "código de cereal procurado", t.getCodCereal().toString());
            return retorno;
        } catch (EmpresaNaoAutorizadaException ex) {
            retorno = new ObjetoRetorno(CodigosRetorno.CODIGO_EMPRESA_NAO_ENCONTRADO, ex.getMessage(), "código de empresa procurado", t.getCodEmpresa().toString());
            return retorno;
        } catch (ProdutorNotFoundException ex) {
            retorno = new ObjetoRetorno(CodigosRetorno.CPF_PRODUTOR_NAO_ENCONTRADO, ex.getMessage(), "cpf procurado", t.getCpfProdutor());
            return retorno;
        } catch (SenhaIncorretaException ex) {
            retorno = new ObjetoRetorno(CodigosRetorno.LOGIN_DA_EMPRESA_INCORRETO, ex.getMessage(), "verifique seus os parâmetros de login", "pa55W0rd");
            return retorno;
        }

        //após validações, persiste o objeto
        try {
            transacaoService.salvar(tc);
            retorno = new ObjetoRetorno(CodigosRetorno.SUCESSO_NA_OPERACAO, "salvo", "código da transação(lembre-se deste código)", tc.getId().toString());
            return retorno;
        } catch (SalvarException ex) {
            retorno = new ObjetoRetorno(CodigosRetorno.ERRO_NA_OPERACAO, ex.getMessage(), "houve um erro ao salvar", "");
            return retorno;
        }
    }

    @WebMethod
    public ObjetoRetorno incluirDebito(@WebParam(name = "transacaoDebito") IncluirTransacaoSampleModel t) {
        TransacaoDebitoServiceImpl transacaoService = new TransacaoDebitoServiceImpl();
        ProdutorServiceImpl produtorService = new ProdutorServiceImpl();

        ObjetoRetorno retorno;

        TransacaoDebito tc = null;

        try {
            tc = (TransacaoDebito) new TransacaoFactory().criarTransacaoParaInclusao(t, new TransacaoDebito());
        } catch (CerealNotFoundException ex) {
            retorno = new ObjetoRetorno(CodigosRetorno.CODIGO_CEREAL_NAO_ENCONTRADO, ex.getMessage(), "código de cereal procurado", t.getCodCereal().toString());
            return retorno;
        } catch (EmpresaNaoAutorizadaException ex) {
            retorno = new ObjetoRetorno(CodigosRetorno.CODIGO_EMPRESA_NAO_ENCONTRADO, ex.getMessage(), "código de empresa procurado", t.getCodEmpresa().toString());
            return retorno;
        } catch (ProdutorNotFoundException ex) {
            retorno = new ObjetoRetorno(CodigosRetorno.CPF_PRODUTOR_NAO_ENCONTRADO, ex.getMessage(), "cpf procurado", t.getCpfProdutor());
            return retorno;
        } catch (SenhaIncorretaException ex) {
            retorno = new ObjetoRetorno(CodigosRetorno.LOGIN_DA_EMPRESA_INCORRETO, ex.getMessage(), "verifique seus os parâmetros de login", "pa55W0rd");
            return retorno;
        }
//        após validações, salva
        try {
            transacaoService.salvar(tc);
//   [ -----------  para o retorno do saldo --------------]            
            Long saldo = produtorService.getSaldoRoyalties(tc.getProdutor(), tc.getSafra());
//   [ -----------  para o retorno do saldo --------------]
            retorno = new ObjetoRetorno(CodigosRetorno.SUCESSO_NA_OPERACAO, "salvo", "saldo após essa transação", saldo.toString());
            return retorno;
        } catch (SalvarException ex) {
            retorno = new ObjetoRetorno(CodigosRetorno.ERRO_NA_OPERACAO, ex.getMessage(), "houve um erro ao salvar", "");
            return retorno;
        }
    }

    @WebMethod
    public ObjetoRetorno incluirProdutor(@WebParam(name = "dadosProdutor") ProdutorSampleModel p) {

        ProdutorServiceImpl produtorService = new ProdutorServiceImpl();
        ObjetoRetorno retorno;
        Produtor pr = null;

        try {
            pr = new ProdutorFactory().criarProdutor(p);
        } catch (CidadeNotFoundException ex) {
            retorno = new ObjetoRetorno(CodigosRetorno.CODIGO_CIDADE_NAO_ENCONTRADO, ex.getMessage(), "código de CIDADE procurado", p.getIdCidade().toString());
            return retorno;
        } catch (CPFInvalidoException ex) {
            retorno = new ObjetoRetorno(CodigosRetorno.CPF_INVALIDO, ex.getMessage(), "cpf procurado", p.getCpf());
            return retorno;
        } catch (ParametroNuloException ex) {
            retorno = new ObjetoRetorno(CodigosRetorno.PARAMETRO_NULO, ex.getMessage(), "", "");
            return retorno;
        }
        try {
            produtorService.salvar(pr);
            retorno = new ObjetoRetorno(CodigosRetorno.SUCESSO_NA_OPERACAO, "salvo", "", "");
            return retorno;
        } catch (SalvarException ex) {
            retorno = new ObjetoRetorno(CodigosRetorno.ERRO_NA_OPERACAO, ex.getMessage(), "houve um erro ao salvar", "");
            return retorno;
        }
    }

    @WebMethod
    public ObjetoRetorno excluiTransacaoDebito(@WebParam(name="transacaoExcluirDebito")ExcluirTransacaoSampleModel t) {
        Transacao tr;
        TransacaoDebitoServiceImpl tDebitoImpl=new TransacaoDebitoServiceImpl();
        ObjetoRetorno retorno = null;
        try {
            tr = new TransacaoFactory().criaTransacaoParaExclusao(t, new TransacaoDebito());
        } catch (EmpresaNaoAutorizadaException ex) {
            retorno = new ObjetoRetorno(CodigosRetorno.CODIGO_EMPRESA_NAO_ENCONTRADO, ex.getMessage(), "código de empresa procurado", t.getCodEmpresa().toString());
            return retorno;
        } catch (SenhaIncorretaException ex) {
            retorno = new ObjetoRetorno(CodigosRetorno.LOGIN_DA_EMPRESA_INCORRETO, ex.getMessage(), "verifique seus os parâmetros de login", "pa55W0rd");
            return retorno;
        } catch (CerealNotFoundException ex) {
            retorno = new ObjetoRetorno(CodigosRetorno.CODIGO_CEREAL_NAO_ENCONTRADO, ex.getMessage(), "código de cereal procurado", t.getIdCereal().toString());
            return retorno;
        } catch (TransacaoNotFoundException ex) {
            retorno = new ObjetoRetorno(CodigosRetorno.TRANSACAO_NAO_ENCONTRADA, ex.getMessage(), "", "");
            return retorno;
        }

        try {
            tDebitoImpl.excluir(tr.getId());
            retorno = new ObjetoRetorno(CodigosRetorno.SUCESSO_NA_OPERACAO, "excluido", "", "");
            return retorno;
        } catch (Exception e) {
            retorno = new ObjetoRetorno(CodigosRetorno.ERRO_NA_OPERACAO, e.getMessage(), "", "");
            return retorno;
        }
    }

    @WebMethod
    public ObjetoRetorno excluiTransacaoCredito(@WebParam(name="transacaoExcluirCredito")ExcluirTransacaoSampleModel t) {
        Transacao tr;
        TransacaoCreditoServiceImpl tCreditoImpl=new TransacaoCreditoServiceImpl();
        ObjetoRetorno retorno = null;
        try {
            tr = new TransacaoFactory().criaTransacaoParaExclusao(t, new TransacaoCredito());
        } catch (EmpresaNaoAutorizadaException ex) {
            retorno = new ObjetoRetorno(CodigosRetorno.CODIGO_EMPRESA_NAO_ENCONTRADO, ex.getMessage(), "código de empresa procurado", t.getCodEmpresa().toString());
            return retorno;
        } catch (SenhaIncorretaException ex) {
            retorno = new ObjetoRetorno(CodigosRetorno.LOGIN_DA_EMPRESA_INCORRETO, ex.getMessage(), "verifique seus os parâmetros de login", "pa55W0rd");
            return retorno;
        } catch (CerealNotFoundException ex) {
            retorno = new ObjetoRetorno(CodigosRetorno.CODIGO_CEREAL_NAO_ENCONTRADO, ex.getMessage(), "código de cereal procurado", t.getIdCereal().toString());
            return retorno;
        } catch (TransacaoNotFoundException ex) {
            retorno = new ObjetoRetorno(CodigosRetorno.TRANSACAO_NAO_ENCONTRADA, ex.getMessage(), "", "");
            return retorno;
        }

        try {
            tCreditoImpl.excluir(tr.getId());
            retorno = new ObjetoRetorno(CodigosRetorno.SUCESSO_NA_OPERACAO, "excluido", "", "");
            return retorno;
        } catch (Exception e) {
            retorno = new ObjetoRetorno(CodigosRetorno.ERRO_NA_OPERACAO, e.getMessage(), "", "");
            return retorno;
        }
    }
}
