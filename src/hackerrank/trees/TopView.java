package hackerrank.trees;

import java.util.*;
        import java.io.*;

public class TopView {

    /*

    class Node
        int data;
        Node left;
        Node right;
    */
    public static void topView(Node root) {
        if(root != null){
            System.out.print(root.data + " ");
            topView(root.right);
        }

    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        System.out.print("Display: ");
        InorderTraversal.inOrder(root);
        System.out.println();
        topView(root);
    }
}