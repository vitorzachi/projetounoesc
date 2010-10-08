
package br.unoesc.ws.objectFactory;

import br.unoesc.ws.exceptions.CPFInvalidoException;
import br.unoesc.ws.exceptions.CidadeNotFoundException;
import br.unoesc.ws.exceptions.ParametroNuloException;
import br.unoesc.ws.model.Produtor;
import br.unoesc.ws.serviceModel.CidadeServiceImpl;
import br.unoesc.ws.util.Validacoes;
import br.unoesc.ws.webModelEntrada.ProdutorSampleModel;

/**
 *
 * @author vitor
 */
public class ProdutorFactory {

    public Produtor criarProdutor(ProdutorSampleModel p) throws CidadeNotFoundException, CPFInvalidoException, ParametroNuloException{
        Produtor pr=new Produtor();
        CidadeServiceImpl cidadeService=new CidadeServiceImpl();

        pr.setCidade(cidadeService.getCidadeById(p.getIdCidade()));

        if(Validacoes.validaCPF(p.getCpf())){
            pr.setCpf(p.getCpf());
        }else{
            throw new CPFInvalidoException();
        }

        if(p.getEndereco()==null){
            throw new ParametroNuloException("endereco");
        }else{
            pr.setEndereco(p.getEndereco());
        }

        if(p.getNome()==null){
            throw new ParametroNuloException("nomePessoa");
        }else{
            pr.setNomePessoa(p.getNome());
        }

        return pr;
    }
}
