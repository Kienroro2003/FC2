package list;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> stringMyLinkedList = new MyLinkedList<>();
        stringMyLinkedList.addFirst("Kien");
        stringMyLinkedList.addFirst("Start");
        for (int i = 5; i >= 1; i--) {
            stringMyLinkedList.addLast("Kien" + i);
        }
//        stringMyLinkedList.add(0,"Kien111");
//        stringMyLinkedList.clear();
//        stringMyLinkedList.addLast("Kien");
//        stringMyLinkedList.removeLast();
        System.out.println(stringMyLinkedList);
        System.out.println("Size: " + stringMyLinkedList.size());
        System.out.println("indexOf: " + stringMyLinkedList.indexOf("Kien"));
        System.out.println("lastIndexOf: " + stringMyLinkedList.lastIndexOf("Kien"));



        LinkedList<String> strings = new LinkedList<>();
//        System.out.println(strings.removeFirst());
        for (int i = 0; i < 5; i++) {
            strings.add("Hello " + i);
        }
//        strings.add(7,"addIndex");
        System.out.println(strings);
//        System.out.println(strings.get(4));
    }
}
