package br.unoesc.ws.fabricaDeObjetos;

import br.unoesc.ws.exceptions.CerealNotFoundException;
import br.unoesc.ws.exceptions.EmpresaNaoAutorizadaException;
import br.unoesc.ws.exceptions.ProdutorNotFoundException;
import br.unoesc.ws.exceptions.SenhaIncorretaException;
import br.unoesc.ws.model.Empresa;
import br.unoesc.ws.model.Transacao;
import br.unoesc.ws.model.TransacaoCredito;
import br.unoesc.ws.model.TransacaoDebito;
import br.unoesc.ws.serviceModel.CerealServiceImpl;
import br.unoesc.ws.serviceModel.EmpresaServiceImpl;
import br.unoesc.ws.serviceModel.ProdutorServiceImpl;
import br.unoesc.ws.webModelEntrada.TransacaoSampleModel;
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
     * @param TransacaoSampleModel t
     */
    public Transacao criarTransacaoGenerica(TransacaoSampleModel t)
            throws CerealNotFoundException,
            EmpresaNaoAutorizadaException,
            ProdutorNotFoundException,
            SenhaIncorretaException {

        Transacao tc = new TransacaoDebito();

        Empresa empresa = null;
        CerealServiceImpl c = new CerealServiceImpl();
        EmpresaServiceImpl e = new EmpresaServiceImpl();
        ProdutorServiceImpl p = new ProdutorServiceImpl();
//--------------[ setando os parametros ]------------------------
        tc.setDataTransacao(new Date());

        tc.setCereal(c.getCerealById(t.getCodCereal())); //exception ok

        empresa = e.getEmpresaById(t.getCodEmpresa());
        tc.setEmpresaGeradora(empresa);  //exception ok

        tc.setNumeroNotaFiscal(t.getNumNotaFiscal()); //nao precisa exception

        tc.setProdutor(p.getByCPF(t.getCpfProdutor()));  //exception ok

        tc.setQuantidade(t.getQtdComprada());  //nao precisa exception

        tc.setSerieNotaFiscal(t.getSerieNotaFiscal());  //nao precisa exception

//--------------[ validando acesso da empresa com senha ]------------------------
        //se senha passada difere da senha cadastrada para a empresa, lanca exception
        if (!t.getSenha().equals(empresa.getSenha())) {
            throw new SenhaIncorretaException();
        }
//--------------[ retorno ]------------------------
        return tc;
    }

    
    public TransacaoCredito g(TransacaoDebito t){
        TransacaoCredito tc=new TransacaoCredito();
        tc.setCereal(t.getCereal());
        tc.setDataTransacao(t.getDataTransacao());
        tc.setEmpresaGeradora(t.getEmpresaGeradora());
        tc.setNumeroNotaFiscal(t.getNumeroNotaFiscal());
        tc.setProdutor(t.getProdutor());
        tc.setQuantidade(t.getQuantidade());
        tc.setSerieNotaFiscal(t.getSerieNotaFiscal());
        return tc;
    }
}
