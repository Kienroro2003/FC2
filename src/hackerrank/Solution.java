package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

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

        public SinglyLinkedList() {
            this.head = null;
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

    // Complete the insertNodeAtTail function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
//    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
//        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
//        newNode.next = head;
//        head = newNode;
//
//        return newNode;
//    }

    //The function below is correct
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode newNode  = new SinglyLinkedListNode(data);
        if (head == null) {
            return head = newNode;
        }
        SinglyLinkedListNode temp  = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;

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

            SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, llistItem);

            llist.head = llist_head;
        }


        printSinglyLinkedList(llist.head, "\n", bufferedWriter);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
