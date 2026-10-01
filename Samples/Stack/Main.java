public class Main {

    public static void main(String[] args) {
        try {
            Stack<Integer> stack = new Stack<>(5);

            stack.push(10);
            stack.push(20);
            stack.push(30);
            stack.display();

            while (!stack.isEmpty()) {
                stack.pop();
                stack.display();
            }
        } catch (OperationFailed exception) {
            System.out.println("Operação inválida.");
        }

    }
}