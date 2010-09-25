package br.unoesc.ws.webService;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author leandro
 */
public abstract class Property {

    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public PropertyChangeSupport getChangeSupport() {
        return changeSupport;
    }

    public void setChangeSupport(PropertyChangeSupport changeSupport) {
        this.changeSupport = changeSupport;
    }
}
