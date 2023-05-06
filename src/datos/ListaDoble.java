
package datos;

import proyecto2.EstructuraDeDatos;
import datos.Usuario; 

public class ListaDoble  extends EstructuraDeDatos{
   
    UsuarioNodo inicio;
    UsuarioNodo fin;
    int longitud;

    @Override
    public void add(Object e) {
        System.out.println("Agregando elemento: " + e);
        // crear un nuevo nodo con el dato que se quiere agregar
        UsuarioNodo nuevoNodo = new UsuarioNodo(e);
        // si la lista esta vacia
        if (fin == null) {
            // el inicio y el fin apuntan al nuevo nodo
            inicio = nuevoNodo;
        } else {
            // sino el siguiente del ultimo nodo apunta al
            nuevoNodo.setAnterior(fin);
            fin.setSiguiente(nuevoNodo);
        }
        // el ultimo nodo es el nuevo nodo
        fin = nuevoNodo;
        // aumentar la longitud de la lista
        longitud++;
    }

    @Override
    public Object peek() {
        // retornar el inicio de la lista
        return inicio;
    }

    @Override
    public Object find(Object e) {
        // crear una copia de nodo para no perder la referencia
        UsuarioNodo actual = inicio;
        // ciclo para recorrer la lista
        while (actual != null) {
            // si el dato del nodo actual es igual al dato que se quiere eliminar
            if (comparar(actual.getDato(), e)) {
                // retornar el nodo actual
                return actual;
            }
            /// sino el nodo copia apunta al siguiente nodo
            actual = actual.getSiguiente();
        }
        return null;
    }

    @Override
    public Object getNext() {
//        return nodo.getSiguiente();
        return null;
    }

    @Override
    public int getSize() {
        return longitud;
    }

    @Override
    public Object get(int indice) {
        if (indice < 0 || indice >= longitud) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        // crear una copia de nodo para no perder la referencia
        UsuarioNodo actual = inicio;
        // ciclo para recorrer la lista hasta el indice
        for (int i = 0; i < indice; i++) {
            // la copia de nodo apunta al siguiente nodo
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
        // crear una copia de nodo para no perder la referencia
        UsuarioNodo actual = inicio;

        // ciclo para recorrer la lista
        while (actual != null) {
            // si el dato del nodo actual es igual al dato que se quiere eliminar
            if (comparar(actual.getDato(), e)) {
                // si el nodo actual es el primero
                if (actual == inicio) {
                    // el inicio de la lista es el siguiente nodo

                    // si hay mas de un nodo en la lista
                    if(inicio.getSiguiente() != null){
                        // el nodo anterior del actual (el que se va a eliminar) apunta a null
                        inicio.getSiguiente().setAnterior(null);
                        // la cabeza de la lista sera el siguiente nodo
                        inicio = inicio.getSiguiente();

                    }
                    // si solo hay un nodo en la lista
                    else{
                        // el fin de la lista apunta a null
                        fin = null;
                    }
                } else if (actual == fin) {
                    // si el nodo actual es el ultimo
                    fin = fin.getAnterior();
                    fin.setSiguiente(null);
                } else {
                    // si el nodo actual esta en medio
                    // el nodo anterior del nodo actual apunta al nodo siguiente del nodo actual
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    // el nodo siguiente del nodo actual apunta al nodo anterior del nodo actual
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                }
                // disminuir la longitud de la lista
                longitud--;
                break;
            }
            // si el dato del nodo actual no es igual al dato que se quiere eliminar
            // avanzar al siguiente nodo
            actual = actual.getSiguiente();
        }
    }

    public boolean comparar(Object ob1, Object ob2){
        // en la lista doble almacenamos los path de las imagenes
        return ob1.equals(ob2);
    }
   
    
    
}
