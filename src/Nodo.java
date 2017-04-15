
public class Nodo<T> {
    
    T dato;
    Nodo siguiente;
    
    public Nodo(T elemento){
        dato = elemento;
        siguiente = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
