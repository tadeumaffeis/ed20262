/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;

/**
 *
 * @author amaffeis
 */
public class Main {

    public static void main(String[] args) {
        BTree<Integer> btree = new BTree<>();
        Scanner in = new Scanner(System.in);
        int value = in.nextInt();
        while (value > 0 && in.hasNext()) {
            btree.add(new NodeTree<Integer>(value));
            value = in.nextInt();
        }
        btree.show();
        System.out.println("Altura: " + btree.height());
        Object[] array = btree.toArray();
        for (int i=0; i < array.length; i++)
        {
            System.out.printf("[%d] = %d", i, (Integer)array[i]);
        }
    }

}
