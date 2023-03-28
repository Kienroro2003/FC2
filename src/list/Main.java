package list;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
       MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
       myLinkedList.addLast(1);
       myLinkedList.addLast(3);
       myLinkedList.addLast(7);
       myLinkedList.addLast(911);
       myLinkedList.addLast(100);
//        System.out.println(myLinkedList.incrementList());
//        myLinkedList.insertIncrement(99);
//       myLinkedList.findMiddleList();
       myLinkedList.reverseList();
        System.out.println(myLinkedList.toString());
    }
}
