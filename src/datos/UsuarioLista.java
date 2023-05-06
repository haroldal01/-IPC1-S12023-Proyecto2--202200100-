
package datos;

import proyecto2.EstructuraDeDatos;
import datos.Usuario; 

public class UsuarioLista extends EstructuraDeDatos{
    
    UsuarioNodo cabeza; 

    private int size; 
    
    
    public UsuarioLista(){
      cabeza = null;
      size = 0;
    }
    
    
    
    // agrega al inicio un dato
    @Override
    public void add(Object dato) {
        UsuarioNodo nuevoNodo = new UsuarioNodo(dato);
            nuevoNodo.setSiguiente(cabeza); 
            cabeza = nuevoNodo;
            size++; 
    }

    @Override
    public Object peek() {
       return cabeza; 
    }

    @Override
    public Object find(Object e) {
        UsuarioNodo actual = cabeza;
        while (actual != null) {
            if (comparar(actual.getDato(), e)) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    @Override
    public Object getNext() {
        return null; 
    }

    @Override
    public int getSize() {
        return size; 
    }

    @Override
    public Object get(int indice) {
        if(indice<0 || indice >= size){
            throw new IndexOutOfBoundsException("indice  fuera de rango"); 
            
        }
        UsuarioNodo actual = cabeza;
        for(int i =0;i<indice;i++){
            actual = actual.getSiguiente(); 
        }
        return actual.getDato(); 
    }

    @Override
    public Object pop() {
        return null; 
    }

    @Override
    public void delete(Object e) {
        if (cabeza == null) {
            return;
        }
        Usuario usuario = (Usuario) e;
        if (( (Usuario) cabeza.getDato()).getNombre().equals(usuario.getNombre())) {
            cabeza = cabeza.getSiguiente();
            size--;
            return;
        }
        UsuarioNodo actual = cabeza;
        while (actual.getSiguiente() != null && !comparar(actual.getSiguiente().getDato(), e)) {
            actual = actual.getSiguiente();
        }
        if (actual.getSiguiente() != null) {
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
            size--;
        }
    }
    
    public boolean comparar(Object ob1, Object ob2){
        // en la lista simple se almacenan usuarios
        Usuario usuario1 = (Usuario) ob1;
        Usuario usuario2 = (Usuario) ob2;
        return usuario1.getNombre().equals(usuario2.getNombre());
    }
    
    
    
    
}
