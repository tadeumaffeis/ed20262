public class PostFixed {
    Stack<Character> expr = new Stack<>(3);
    
    public PostFixed(Stack<Character> expr)
    {
        this.expr = expr;
    }

    public long exec() throws OperationFailed, Exception
    {
        long retValue = 0;
        char op = expr.pop().charValue();
        switch (op)
        {
            case '+' : 
                retValue = doSum();
                break;
            case '-' :
                retValue = doSubtr();
                break;
            default:
                throw new Exception("Error");
        }

        return retValue;
    }

    private long doSum()
    {   
        long retValue = 0;
        try {
            long n1 = (long) Character.getNumericValue(expr.pop().charValue());
            long n2 = (long) Character.getNumericValue(expr.pop().charValue());
            retValue = n1 + n2;
        } catch (OperationFailed e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return retValue;
    }

    private long doSubtr()
    {   
        long retValue = 0;
        try {
            long n2 = (long) Character.getNumericValue(expr.pop().charValue());
            long n1 = (long) Character.getNumericValue(expr.pop().charValue());
            retValue = n1 - n2;
        } catch (OperationFailed e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return retValue;
    }
    


}

