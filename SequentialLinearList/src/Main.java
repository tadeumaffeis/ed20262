import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int capacity = input.nextInt();
        SequentialLinearList list =
            new SequentialLinearList(capacity);

        while (!list.isFull() && input.hasNextInt()) {
            int value = input.nextInt();

            if (value < 0) {
                break;
            }

            list.add(value);
        }

        list.display();
        input.close();
    }
}