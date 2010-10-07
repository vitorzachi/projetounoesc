package br.unoesc.ws.webServiceMethods;

import br.unoesc.ws.configs.CodigosRetorno;
import br.unoesc.ws.exceptions.CerealNotFoundException;
import br.unoesc.ws.exceptions.EmpresaNaoAutorizadaException;
import br.unoesc.ws.exceptions.ProdutorNotFoundException;
import br.unoesc.ws.exceptions.SalvarException;
import br.unoesc.ws.exceptions.SenhaIncorretaException;
import br.unoesc.ws.fabricaDeObjetos.TransacaoFactory;
import br.unoesc.ws.model.TransacaoCredito;
import br.unoesc.ws.model.TransacaoDebito;
import br.unoesc.ws.serviceModel.ProdutorServiceImpl;
import br.unoesc.ws.serviceModel.SafraServiceImpl;
import br.unoesc.ws.serviceModel.TransacaoCreditoServiceImpl;
import br.unoesc.ws.serviceModel.TransacaoDebitoServiceImpl;
import br.unoesc.ws.webModelEntrada.TransacaoSampleModel;
import br.unoesc.ws.webModelRetorno.ObjetoRetorno;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public ObjetoRetorno incluirCredito(@WebParam(name = "transacaoCredito") TransacaoSampleModel t) {

        TransacaoCreditoServiceImpl transacaoService = new TransacaoCreditoServiceImpl();
        ObjetoRetorno retorno;

        TransacaoCredito tc = null;

        try {
            tc =  new TransacaoFactory().criarTransacaoCredito((TransacaoDebito) new TransacaoFactory().criarTransacaoDebito(t));
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
            retorno = new ObjetoRetorno(CodigosRetorno.SUCESSO_AO_SALVAR, "salvo", "código da transação(lembre-se deste código)", tc.getId().toString());
            return retorno;
        } catch (SalvarException ex) {
            retorno = new ObjetoRetorno(CodigosRetorno.ERRO_AO_SALVAR, ex.getMessage(), "houve um erro ao salvar", null);
            return retorno;
        }
    }

    @WebMethod
    public ObjetoRetorno incluirDebito(@WebParam(name = "transacaoDebito") TransacaoSampleModel t) {
        TransacaoDebitoServiceImpl transacaoService = new TransacaoDebitoServiceImpl();
        ProdutorServiceImpl produtorService = new ProdutorServiceImpl();
        SafraServiceImpl safraService = new SafraServiceImpl();

        ObjetoRetorno retorno;

        TransacaoDebito tc = null;

        try {
            tc = (TransacaoDebito) new TransacaoFactory().criarTransacaoDebito(t);
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
            Long saldo = produtorService.getSaldoRoyalties(tc.getProdutor(), safraService.getSafraCorrente(tc.getCereal()));
//   [ -----------  para o retorno do saldo --------------]
            retorno = new ObjetoRetorno(CodigosRetorno.SUCESSO_AO_SALVAR, "salvo", "saldo após essa transação", saldo.toString());
            return retorno;
        } catch (SalvarException ex) {
            retorno = new ObjetoRetorno(CodigosRetorno.ERRO_AO_SALVAR, ex.getMessage(), "houve um erro ao salvar", null);
            return retorno;
        }
    }
}
