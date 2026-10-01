import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinkedLinearList<Integer> list = new LinkedLinearList<>(10);

        for (int i = 0; i < 10; i++) {
            int value = scanner.nextInt();

            list.add(value);
        }

        System.out.printf("Somatorio       : %10.0f\n", list.sum());
        System.out.printf("Produtorio      : %10.0f\n", list.product());
        System.out.printf("Media aritmetica: %10.0f\n", list.average());

        scanner.close();
    }
}