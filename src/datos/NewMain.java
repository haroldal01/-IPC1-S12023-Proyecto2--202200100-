
package datos;

import datos.ListaDoble; 
import datos.UsuarioLista; 
import datos.Usuario;

import java.io.File; 

public class NewMain {

    
    public static ListaDoble listaDoble = new ListaDoble();
    public static void main(String[] args) {
        
      UsuarioLista lista = new UsuarioLista();
        lista.add(new Usuario(""));
        lista.add(new Usuario(""));
        lista.add(new Usuario(""));
        // eliminar un elemento de la lista
        lista.delete(new Usuario(""));

        lista.add(new Usuario(""));
        System.out.println("Longitud de la lista: " + lista.getSize());
        for (int i = 0; i < lista.getSize(); i++) {
            System.out.println("Elemento " + i + ": " + ((Usuario)lista.get(i)).getNombre());
        }  
        
        //iterar sobre la lista utilizando el getSiguiente()
        UsuarioNodo actual = (UsuarioNodo) lista.peek();
        while(actual != null){
            System.out.println("Elemento: " + ((Usuario)actual.getDato()).getNombre());
            actual = actual.getSiguiente();
        }
    }
    
}
