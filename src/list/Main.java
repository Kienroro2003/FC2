package list;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
       MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
       myLinkedList.addLast(1);
       myLinkedList.addLast(3);
       myLinkedList.addLast(7);
       myLinkedList.addLast(9);
       myLinkedList.addLast(10);
       myLinkedList.findMiddleList();
        System.out.println(myLinkedList.toString());
    }
}
