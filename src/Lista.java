

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Lista<T> implements Iterable<T> {

    private T dato;
    private NodoDoble inicio;
    private NodoDoble fin;

    public Lista() {
        inicio = null;
        fin = null;
    }

    public Boolean isEmpty() {
        return inicio == null;
    }

    public void add(T elem) {
        NodoDoble<T> nuevo = new NodoDoble(elem);
        if (isEmpty()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            nuevo.setAnterior(fin);
            fin = nuevo;
        }
    }

    public T drop() throws ListaVaciaException {
        T resultado = null;
        if (isEmpty()) {
            throw new ListaVaciaException();
        }
        NodoDoble<T> aux = fin;
        resultado = aux.getDato();
        if (inicio == fin) {
            inicio = null;
            fin = null;
        } else {
            fin = fin.getAnterior();
            fin.setSiguiente(null);
            aux.setAnterior(null);
        }
        return resultado;
    }

    public void empty() {
        try {
            while (true) {
                drop();
            }
        } catch (ListaVaciaException ex) {
            //ex.printStackTrace();
        }
    }

    public void show() {
        NodoDoble<T> aux = inicio;
        while (aux != null) {
            System.out.println(aux.getDato());
            aux = aux.getSiguiente();
        }
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {

            private NodoDoble<T> auxiliar = inicio;

            @Override
            public boolean hasNext() {
                return auxiliar != null;
            }

            @Override
            public T next() {
                T elem = auxiliar.getDato();
                auxiliar = auxiliar.getSiguiente();
                return elem;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        return iterator;
    }

}
