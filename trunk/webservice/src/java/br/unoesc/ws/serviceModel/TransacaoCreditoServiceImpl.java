
package br.unoesc.ws.serviceModel;

import br.unoesc.ws.exceptions.SalvarException;
import br.unoesc.ws.model.Boleto;
import br.unoesc.ws.model.PrecoSafra;
import br.unoesc.ws.model.TransacaoCredito;

/**
 *
 * @author vitor
 */
public class TransacaoCreditoServiceImpl extends GenericServiceImpl<TransacaoCredito>{

    @Override
    public void salvar(TransacaoCredito t)
            throws SalvarException{

        Boleto b=new Boleto();
        b.setTransacaoCredito(t);
        b.setPago(false);
        b.setValor(this.getValorBoleto(t));
        t.setBoletoGerado(b);

        super.salvar(t);
    }

    private Float getValorBoleto(TransacaoCredito t){
//        SafraServiceImpl s=new SafraServiceImpl();
        PrecoSafraServiceImpl psImpl=new PrecoSafraServiceImpl();
        PrecoSafra ps=psImpl.getPrecoPorSafra(t.getSafra());
        return ps.getPrecoPorKgSemente()*t.getQuantidade();
    }
}
