package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution2 {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    class Result {

        /*
         * Complete the 'insertNodeAtPosition' function below.
         *
         * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
         * The function accepts following parameters:
         *  1. INTEGER_SINGLY_LINKED_LIST llist
         *  2. INTEGER data
         *  3. INTEGER position
         */

        /*
         * For your reference:
         *
         * SinglyLinkedListNode {
         *     int data;
         *     SinglyLinkedListNode next;
         * }
         *
         */

        public  SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
            // Write your code here

            return llist;
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("/Users/kienroro2003/Documents/My MacOS/DuyTan/Fundamentals of Computing/FC2/src/hackerrank/result")));

        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            llist.insertNode(llistItem);
        }

//        int data = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int position = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        SinglyLinkedListNode llist_head = deleteNode(llist.head, position);

        printSinglyLinkedList(llist_head, " ", bufferedWriter);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    private static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode temp = head;
        for(int i = 0; i < position - 1; i++){
            temp = temp.next;
        }
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        SinglyLinkedListNode afterNode = temp.next;
        temp.next = newNode;
        newNode.next = afterNode;
        return head;
    }

    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
        // Write your code here
        SinglyLinkedListNode temp = llist;
        if(position == 0){
            llist = llist.next;
            return llist;
        }
        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return llist;
    }

    public static void reversePrint(SinglyLinkedListNode llist) {
        // Write your code here
        SinglyLinkedListNode node = null;
        while (llist != null){
            SinglyLinkedListNode temp = node;
            node = new SinglyLinkedListNode(llist.data);
            node.next = temp;
            llist = llist.next;
        }
        while (node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        SinglyLinkedListNode node = null;
        while (llist != null){
            SinglyLinkedListNode temp = node;
            node = new SinglyLinkedListNode(llist.data);
            node.next = temp;
            llist = llist.next;
        }
        return node;
    }

//    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
//        while(head1 != null && head2 != null){
//            if(head1.data != head2.data ){
//                return false;
//            }
//            head1 = head1.next;
//            head2 = head2.next;
//
//        }
//
//        return true;
//    }
    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        while(head1 != null){
            if(head1.data != head2.data ){
                return false;
            }
            if((head1.next != null && head2.next == null) || (head1.next == null && head2.next != null)){
                return false;
            }else{
                head1 = head1.next;
                head2 = head2.next;
            }

        }

        return true;
    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode node = head1;
        while (node.next != null){
            node = node.next;
        }
        while (head2 != null){
            node.next = new SinglyLinkedListNode(head2.data);
            node = node.next;
            head2 = head2.next;
        }
        node = head1;
        SinglyLinkedListNode index = null;
        int temp;
        while (node != null) {
            // Node index will point to node next to
            // current
            index = node.next;

            while (index != null) {
                // If current node's data is greater
                // than index's node data, swap the data
                // between them
                if (node.data > index.data) {
                    temp = node.data;
                    node.data = index.data;
                    index.data = temp;
                }

                index = index.next;
            }
            node = node.next;
        }

        return head1;

    }

    public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
        // Write your code here
        SinglyLinkedListNode node = null;
        while (llist != null){
            SinglyLinkedListNode temp = node;
            node = new SinglyLinkedListNode(llist.data);
            node.next = temp;
            llist = llist.next;
        }
        for (int i = 0; i < positionFromTail; i++) {
            node = node.next;
        }
        return node.data;
    }

    public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode llist) {
        if (llist == null) {
            return null;
        }

        SinglyLinkedListNode current = llist;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return llist;
    }

//    static boolean hasCycle(SinglyLinkedListNode head) {
//        SinglyLinkedListNode temp = head;
//        Map<Integer, SinglyLinkedListNode> map = new LinkedHashMap<>();
//        while (head != null){
//            if(!map.containsKey(head.data)){
//                map.put(head.data, head);
//            }else if(map.get(head.data) == head){
//                return true;
//            }
//            head = head.next;
//        }
//        return false;
//    }
    static boolean hasCycle(SinglyLinkedListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        head1 = reverse(head1);
        head2 = reverse(head2);
        while (head1.next == head2.next){
            head1 = head1.next;
            head2 = head2.next;
        }

        return head1.data;
    }


}
