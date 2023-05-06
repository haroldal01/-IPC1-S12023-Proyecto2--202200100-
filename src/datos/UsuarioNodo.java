
package datos;

import datos.Usuario; 
import javax.swing.ImageIcon;

public class UsuarioNodo {
   
    Object dato;

    // para lista simple y doble
    private UsuarioNodo siguiente;

    // lista doble
    private UsuarioNodo anterior;
    UsuarioNodo sig;


    public UsuarioNodo(Object dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public UsuarioNodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(UsuarioNodo siguiente) {
        this.siguiente = siguiente;
    }

    public UsuarioNodo getAnterior() {
        return anterior;
    }

    public void setAnterior(UsuarioNodo anterior) {
        this.anterior = anterior;
    }

    public void setSize(int iconWidth, int iconHeight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setIcon(ImageIcon imagen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
