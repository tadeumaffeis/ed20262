
public class Convert {
    StringBuffer sb = new StringBuffer();
    Stack<Character> stackN = new Stack<>(100);
    Stack<Character> stackO = new Stack<>(50);

    public Convert(String expr) throws Exception {
        sb.append(expr);
        validate();
        for (int i = 0; i < sb.length(); i++) {
            if (i % 2 == 0) {
                stackN.push(sb.charAt(i));
            } else {
                stackO.push(sb.charAt(i));
            }
        }
    }

    private boolean validate() throws Exception {
        if (sb.length() == 0)
            throw new Exception("Empty expression");
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(0) != '+' &&
                    sb.charAt(0) != '-' &&
                    (sb.charAt(0) < '0' || sb.charAt(0) > '9'))
                throw new Exception("Expression cannot start with an operator");
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        Stack<Character> newStackN = new Stack<>(100);
        Stack<Character> newStackO = new Stack<>(50);
        try {
            while (!stackN.isEmpty()) {
                char c = stackN.pop().charValue();
                newStackN.push(c);
            }
            while (!stackO.isEmpty()) {
                char c = stackO.pop().charValue();
                newStackO.push(c);
            }
            result.append(newStackN.pop());
            while (!newStackN.isEmpty()) {
                result.append(newStackN.pop());
                result.append(newStackO.pop());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result.toString();
    }
}