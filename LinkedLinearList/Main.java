import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int capacity = input.nextInt();
        LinkedLinearList list =
            new LinkedLinearList<String>(capacity);
        input.nextLine();

        while (!list.isFull() && input.hasNextLine()) {
            String value = input.nextLine();

            if (value.isEmpty()) {
                break;
            }

            list.add(value);
        }

        String searchValue = input.nextLine();
        int position = list.search(searchValue);
        if (position != -1) {
            System.out.println("Valor encontado na posicao: " + position);
        } else {
            System.out.println("Valor nao encontrado");
        }

        list.display();

        try {
            Object removedValue = list.remove(position);
            System.out.println("Valor removido: " + removedValue.toString());
        } catch (OperationFailed ex) {
            System.getLogger(Main.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        list.display();

        input.close();
    }
}