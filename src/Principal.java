public class Principal {

   
    public static void main(String[] args) throws ArithmeticExpresionException {
            
        ShuntingYard sy = new ShuntingYard();
        sy.addElement(new Operation(MathSign.PARENTESISIZQ));
        sy.addElement(new Numero('Z'));
        sy.addElement(new Operation(MathSign.MULTIPLICACION));
        sy.addElement(new Operation(MathSign.PARENTESISIZQ));
        sy.addElement(new Numero('K'));
        sy.addElement(new Operation(MathSign.RESTA));
        sy.addElement(new Numero('W'));
        sy.addElement(new Operation(MathSign.PARENTESISDER));
        sy.addElement(new Operation(MathSign.SUMA));
        sy.addElement(new Numero('X'));
        sy.addElement(new Operation(MathSign.PARENTESISDER));
        sy.addElement(new Operation(MathSign.EXPONENTE));
        sy.addElement(new Numero('Y'));
        sy.addElement(new Operation(MathSign.RESTA));
        sy.addElement(new Numero('T'));
        

        
        
        sy.evaluate();
        
        
        
        Pantalla p = new Pantalla();
        

    }

}
