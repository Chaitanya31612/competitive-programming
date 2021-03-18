package linkedlist;

import java.util.LinkedList;

public class CollectionsLL {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        System.out.println(list.size());

        list.add(10);
        list.add(20);
        System.out.println(list.size());

        System.out.println(list.peek());
        LinkedList<Integer> list2 = (LinkedList<Integer>) list.clone();
        list2.clear();
        System.out.println(list2.peek());
    }
}
