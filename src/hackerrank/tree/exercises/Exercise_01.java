package hackerrank.tree.exercises;

import java.util.LinkedList;
import java.util.Queue;

public class Exercise_01 {
    class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    Node root;
    Node add(Node root, int x){
        if(root == null){
            return new Node(x);
        }else if(root.value < x){
            root.right = add(root.right, x);
        }else if(root.value > x){
            root.left = add(root.left, x);
        }
        return root;
    }

    void preOrder(Node root){
        if(root != null){
            System.out.print(root.value + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    void inerOrder(Node root){
        if(root != null){
            inerOrder(root.left);
            System.out.print(root.value + " ");
            inerOrder(root.right);
        }
    }

    void widthOrder(){
        Queue<Node> queue = new LinkedList<>();
        if(this.root != null)queue.add(this.root);
        while(!queue.isEmpty()){
            Node x = queue.remove();
            System.out.print(x.value + " ");
            if(x.left != null)queue.add(x.left);
            if(x.right != null)queue.add(x.right);
        }
    }

    Node tx(int x, Node root){
        if(root == null){
            System.out.println("Sos");
        }else if(x < root.value)root.left = tx(x, root.left);
        else if(x > root.value) root.right = tx(x, root.right);
        else{
            if(root.left == null && root.right == null)root = null;
            else if(root.left == null)root = root.right;
            else if(root.right == null)root = root.left;
            else{
                Node temp = root.left;
                while (temp.right != null)temp = temp.right;
                root.value = temp.value;
                root.left = tx(temp.value, root.left);
            }
        }
        return root;
    }


    public static void main(String[] args) {
        Exercise_01 ex = new Exercise_01();
        ex.root = ex.add(ex.root, 34);
        ex.add(ex.root, 20);
        ex.add(ex.root, 8);
        ex.add(ex.root, 66);
        ex.add(ex.root, 32);
        ex.add(ex.root, 15);
        ex.add(ex.root, 99);
        ex.add(ex.root, 1);
        ex.add(ex.root, 42);
        ex.add(ex.root, 37);
        ex.add(ex.root, 28);
        ex.add(ex.root, 66);
        ex.add(ex.root, 73);
        ex.add(ex.root, 25);
        ex.preOrder(ex.root);
        System.out.println();
        ex.inerOrder(ex.root);
        System.out.println();
        ex.widthOrder();
        System.out.println();
        ex.tx(20, ex.root);
        ex.widthOrder();
    }
}
