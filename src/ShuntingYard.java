

public class ShuntingYard {

    private Queue<Arithmeticable> infija;
    private Queue<Arithmeticable> polaca;
    private Stack<Operation> stack;

    public ShuntingYard() {
        try {
            infija = new Queue<>();
            polaca = new Queue<>();
            stack = new Stack<>();
        } catch (InvalidQueueSizeException | InvalidStackSizeException ex) {
            ex.printStackTrace();
        }
    }

    public void addElement(Arithmeticable elem) {
        try {
            infija.enqueue(elem);
        } catch (QueueOverFlowException ex) {
            ex.printStackTrace();
        }
    }

    private void compararSignos(Operation elemento) throws StackOverFlowException, StackUnderFlowException, QueueOverFlowException {
        if (elemento.getOperator() == MathSign.PARENTESISIZQ) {
            stack.push(elemento);
        } else if (elemento.getOperator() == MathSign.PARENTESISDER) {
            Operation aux = stack.pop();
            while (aux.getOperator() != MathSign.PARENTESISIZQ) {
                polaca.enqueue(aux);
                aux = stack.pop();
            }
        } else {
            if (stack.isEmptyStack()) {
                stack.push(elemento);
            } else {
                Operation aux = stack.pop();
                if (elemento.compareTo(aux) >= 0) {
                    stack.push(aux);
                    stack.push(elemento);
                } else {
                    stack.push(elemento);
                    polaca.enqueue(aux);
                }
            }
        }
    }

    public Lista evaluate() throws ArithmeticExpresionException {
        Lista salida = null;
        try {
            Arithmeticable elemento;
            while (!infija.isEmptyQueue()) {
                elemento = infija.dequeue();
                if (!elemento.isOperator()) {
                    polaca.enqueue(elemento);
                } else {
                    compararSignos((Operation) elemento);
                }
            }
            while (!stack.isEmptyStack()) {
                polaca.enqueue(stack.pop());
            }
            salida = new Lista();
            while (!polaca.isEmptyQueue()){
                salida.add(polaca.dequeue());
            }
        } catch (QueueUnderFlowException | QueueOverFlowException | StackOverFlowException | StackUnderFlowException ex) {
            throw new ArithmeticExpresionException();
        }
        return salida;
    }
    

}
