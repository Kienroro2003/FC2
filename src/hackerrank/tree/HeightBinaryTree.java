package hackerrank.tree;

import hackerrank.tree.InorderTraversal;
import hackerrank.tree.Node;

import java.util.*;


public class HeightBinaryTree {

    /*
    class Node
        int data;
        Node left;
        Node right;
    */
    public static int height(Node root) {
        // Write your code here.
        if(root == null){
            return -1;
        }else{
            int left = height(root.left);
            int right = height(root.right);
            return Math.max(left, right) + 1;
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
        System.out.println("hello world");
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        InorderTraversal.inOrder(root);
        int height = height(root);
        System.out.println(height);
    }
}
