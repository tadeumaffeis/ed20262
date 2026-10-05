import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            Stack<Character> stack = new Stack<>(3);
            System.out.println("Expressão: ");
            String sExpr = in.nextLine();

            stack.push(sExpr.charAt(0));
            stack.push(sExpr.charAt(1));
            stack.push(sExpr.charAt(2));

            PostFixed ps = new PostFixed(stack);

            stack.display();

            try {
                System.out.println("Resultado: " + ps.exec());
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

    }
}