

import java.text.DecimalFormat;


public class Numero implements Arithmeticable {

    private Character dato;
    
    public Numero(Character dato){
        this.dato = dato;
    }
    
    @Override
    public boolean isOperator() {
        return false;
    }
    
    public String toString(){
        return String.valueOf(dato);
    }
    
    public Character getDato(){
        return dato;
    }



}
