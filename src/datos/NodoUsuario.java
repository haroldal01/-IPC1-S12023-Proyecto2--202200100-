
package datos;

import datos.Usuario; 

public class NodoUsuario {
   
    private Object dato; 
    
    // para lista simple y doble
    private NodoUsuario siguiente;

    // lista doble
    private NodoUsuario anterior;


    public NodoUsuario(Object dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoUsuario getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoUsuario siguiente) {
        this.siguiente = siguiente;
    }

    public NodoUsuario getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoUsuario anterior) {
        this.anterior = anterior;
    }
}
