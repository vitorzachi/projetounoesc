package br.unoesc.ws.objectFactory;

import br.unoesc.ws.exceptions.CerealNotFoundException;
import br.unoesc.ws.exceptions.EmpresaNaoAutorizadaException;
import br.unoesc.ws.exceptions.ProdutorNotFoundException;
import br.unoesc.ws.exceptions.SenhaIncorretaException;
import br.unoesc.ws.exceptions.TransacaoNotFoundException;
import br.unoesc.ws.model.Empresa;
import br.unoesc.ws.model.Transacao;
import br.unoesc.ws.model.TransacaoCredito;
import br.unoesc.ws.model.TransacaoDebito;
import br.unoesc.ws.serviceModel.CerealServiceImpl;
import br.unoesc.ws.serviceModel.EmpresaServiceImpl;
import br.unoesc.ws.serviceModel.EstadoServiceImpl;
import br.unoesc.ws.serviceModel.ProdutorServiceImpl;
import br.unoesc.ws.serviceModel.SafraServiceImpl;
import br.unoesc.ws.serviceModel.TransacaoCreditoServiceImpl;
import br.unoesc.ws.serviceModel.TransacaoDebitoServiceImpl;
import br.unoesc.ws.webModelEntrada.ExcluirTransacaoSampleModel;
import br.unoesc.ws.webModelEntrada.IncluirTransacaoSampleModel;
import java.util.Date;

/** classe que contem os metodos de geracao de objetos
 * @see TransacaoCredito
 *
 * @author vitor
 */
public class TransacaoFactory {

    /** classe responsavel por receber um objeto com parametros simples e
     * criar o objeto TransacaoDebito propriamente dito, validando os campos
     * e gerando exceptions que serao utilizadas nas mensagens de retorno do WS
     *
     * OBS: pode ser usado também para gerar uma TransacaoCredito, pelo
     * fato de esta ser uma classe filha da classe TransacaoDebito
     * @see TransacaoCredito
     *
     * @param IncluirTransacaoSampleModel t
     * @param Transacao tipoClasseRetorno - passa um objeto novo do tipo de retorno esperado(credito ou debito)
     */
    public Transacao criarTransacaoParaInclusao(IncluirTransacaoSampleModel t, Transacao tipoClasseRetorno)
            throws CerealNotFoundException,
            EmpresaNaoAutorizadaException,
            ProdutorNotFoundException,
            SenhaIncorretaException {
//cria um novo objeto, caso o parametro "tipoClasseRetorno" for nulo
        if (tipoClasseRetorno == null) {
            tipoClasseRetorno = (tipoClasseRetorno instanceof TransacaoCredito) ? new TransacaoCredito() : new TransacaoDebito();
        }

        Empresa empresa = null;
        SafraServiceImpl s = new SafraServiceImpl();
        CerealServiceImpl c = new CerealServiceImpl();
        EmpresaServiceImpl e = new EmpresaServiceImpl();
        ProdutorServiceImpl p = new ProdutorServiceImpl();
        EstadoServiceImpl es = new EstadoServiceImpl();
//--------------[ setando os parametros ]------------------------
        tipoClasseRetorno.setDataTransacao(new Date());

        tipoClasseRetorno.setSafra(s.getSafraCorrente(c.getCerealById(t.getCodCereal())));
//        tc.setCereal(); //exception ok

        empresa = e.getEmpresaById(t.getCodEmpresa());
        tipoClasseRetorno.setEmpresaGeradora(empresa);  //exception ok

        tipoClasseRetorno.setNumeroNotaFiscal(t.getNumNotaFiscal()); //nao precisa exception

        tipoClasseRetorno.setProdutor(p.getByCPF(t.getCpfProdutor()));  //exception ok

        tipoClasseRetorno.setQuantidade(t.getQtdComprada());  //nao precisa exception

        tipoClasseRetorno.setSerieNotaFiscal(t.getSerieNotaFiscal());  //nao precisa exception

//--------------[ validando acesso da empresa com senha ]------------------------
        //se senha passada difere da senha cadastrada para a empresa, lanca exception
        if (!t.getSenha().equals(empresa.getSenha())) {
            throw new SenhaIncorretaException();
        }
//--------------[ retorno ]------------------------
        return tipoClasseRetorno;
    }

    public Transacao criaTransacaoParaExclusao(ExcluirTransacaoSampleModel t, Transacao tipoClasseRetorno)
            throws EmpresaNaoAutorizadaException,
            SenhaIncorretaException,
            CerealNotFoundException,
            TransacaoNotFoundException {

        Empresa empresa = null;
        SafraServiceImpl s = new SafraServiceImpl();
        EmpresaServiceImpl e = new EmpresaServiceImpl();

        empresa = e.getEmpresaById(t.getCodEmpresa());

        TransacaoCreditoServiceImpl tCreditoImpl = new TransacaoCreditoServiceImpl();
        TransacaoDebitoServiceImpl tDebitoImpl = new TransacaoDebitoServiceImpl();

//--------------[ validando acesso da empresa com senha ]------------------------
        //se senha passada difere da senha cadastrada para a empresa, lanca exception
        if (!t.getSenha().equals(empresa.getSenha())) {
            throw new SenhaIncorretaException();
        }
//--------------[ retorno ]------------------------
        if (tipoClasseRetorno instanceof TransacaoCredito) {
            tipoClasseRetorno = tCreditoImpl.getTransacao(t.getNumeroNotaFiscal(), t.getSerieNotaFiscal(), t.getCodEmpresa(), t.getIdCereal());
        } else if (tipoClasseRetorno instanceof TransacaoDebito) {
            tipoClasseRetorno = tDebitoImpl.getTransacao(t.getNumeroNotaFiscal(), t.getSerieNotaFiscal(), t.getCodEmpresa(), t.getIdCereal());
        }

        return tipoClasseRetorno;
    }
}
