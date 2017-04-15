
public class Operation implements Arithmeticable, Comparable<Operation> {
    
    private MathSign operator;

    public Operation(MathSign op){
        operator = op;
    }
    
    @Override
    public boolean isOperator() {
        return true;
    }

    @Override
    public int compareTo(Operation o) {
        return getOperator().getLevel() - o.getOperator().getLevel();
    }

    public String toString(){
        return operator.toString();
    }
    
    public MathSign getOperator() {
        return operator;
    }

    public void setOperator(MathSign operator) {
        this.operator = operator;
    }
    
    
}
