
package br.unoesc.ws.presentationModel;


import br.unoesc.ws.exceptions.AlterarException;
import br.unoesc.ws.exceptions.SalvarException;
import br.unoesc.ws.model.GenericModel;
import br.unoesc.ws.serviceModel.GenericServiceImpl;
import br.unoesc.ws.webService.Property;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Leandro
 */
public abstract class GenericPresentionModel<ModelClass extends GenericModel, GenericService extends GenericServiceImpl> extends Property {

    private ModelClass objetoSelecionado;
    private List<ModelClass> lista;
    private GenericService regras;

    public GenericPresentionModel(){
        
    }
    
    public GenericPresentionModel(ModelClass objeto) {
        criaRegra();
        lista = ObservableCollections.observableList(new ArrayList<ModelClass>());
        novo(objeto);
    }

    public abstract void criaRegra();

    public void salvar(){
        try {
            regras.salvarOuAlterar(objetoSelecionado);
        } catch (SalvarException ex) {
            Logger.getLogger(GenericPresentionModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AlterarException ex) {
            Logger.getLogger(GenericPresentionModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void novo(ModelClass objeto){
        setObjetoSelecionado(objeto);
    }

    public void remove(){
        regras.excluir(objetoSelecionado.getId());
    }

    public void localizarObjetos(){
        getLista().clear();
        getLista().addAll(regras.getAll());
    }

    public ModelClass getObjetoSelecionado() {
        return objetoSelecionado;
    }

    public void setObjetoSelecionado(ModelClass objetoSelecionado) {
        ModelClass oldObjeto = this.objetoSelecionado;
        this.objetoSelecionado = objetoSelecionado;
        getChangeSupport().firePropertyChange("objetoSelecionado", oldObjeto, objetoSelecionado);
    }

    public List<ModelClass> getLista() {
        return lista;
    }

    public void setLista(List<ModelClass> lista) {
        List<ModelClass> oldLista = this.lista;
        this.lista = lista;
        getChangeSupport().firePropertyChange("lista", oldLista, this.lista);
    }

    public GenericService getRegras() {
        return regras;
    }

    public void setRegras(GenericService regras) {
        this.regras = regras;
    }

}
