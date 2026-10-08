import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Convert convert = null;

        System.out.printf("\nEnter an expression: ");
        try {
            convert = new Convert(in.nextLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.printf("\nConverted expression: %s\n", convert.toString());

    }
}