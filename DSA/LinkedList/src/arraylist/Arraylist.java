package arraylist;

import java.util.ArrayList;

public class Arraylist {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        for(int elem : list) {
            System.out.print(elem + " ");
        }

        System.out.println();
        list.add(3, 25);
        for(int elem : list) {
            System.out.print(elem + " ");
        }
    }
}
