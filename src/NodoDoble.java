
public class NodoDoble<T> {
    
    T dato;
    NodoDoble siguiente;
    NodoDoble anterior;
    
    public NodoDoble(T elemento){
        dato = elemento;
        siguiente = null;
        anterior = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }
    
    
}
