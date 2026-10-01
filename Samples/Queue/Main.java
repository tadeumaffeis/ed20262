import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(5);
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            queue.enqueue(in.nextInt());
        }
        queue.display();
        while (!queue.isEmpty()) {
            try {
                queue.dequeue();
            } catch (OperationFailed e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            queue.display();
        }

    }
}