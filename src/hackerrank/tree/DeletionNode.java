package hackerrank.tree;

import java.util.Scanner;

public class DeletionNode {

    public static void preOrder( Node root ) {

        if( root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

 /* Node is defined as :
 class Node
    int data;
    Node left;
    Node right;

    */

    public static Node minNode(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static Node removeNode(Node root, int data){
        if(root.data > data){
            root.left = removeNode(root.left, data);
        }else if(root.data < data){
            root.right = removeNode(root.right, data);
        }else{
            if(root.left == null && root.right == null){
                return null;
            }else if(root.left != null && root.right == null){
                return root.left;
            }else if(root.left == null && root.right != null){
                return root.right;
            }else{
                Node successor = minNode(root.right);
                root.data = successor.data;
                root.right = removeNode(root.right, successor.data);
            }
        }
        return root;
    }

    public static Node insert(Node root, int data) {
        if(root == null){
            root = new Node(data);
        }else if(root.data > data){
            root.left = insert(root.left, data);
        }else{
            root.right = insert(root.right, data);
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
//            System.out.println(insert(root, data).data);
            root = insert(root, data);
        }
        scan.close();
        preOrder(root);
        System.out.println();
        root = removeNode(root, 30);
        preOrder(root);
    }
}
