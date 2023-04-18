package hackerrank.tree;
import java.util.*;

class TopView {

    /*

    class Node
        int data;
        Node left;
        Node right;
    */
    static void eRight(Node root){
        if(root != null){
            System.out.print(root.data + " ");
            eRight(root.right);
        }
    }

    static void eLeft(Node root){
        if(root != null){
            eLeft(root.left);
            System.out.print(root.data + " ");
        }
    }
    public static void topView(Node root) {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> pos = new LinkedList<>();
        pos.add(0);
        queue.add(root);
        while (!queue.isEmpty()){
            int p = pos.remove();
            Node node = queue.remove();
            if(!map.containsKey(p)){
                map.put(p, node.data);
            }
            if (node.left != null) {
                queue.add(node.left);
                pos.add(p - 1);
            }

            if (node.right != null) {
                queue.add(node.right);
                pos.add(p + 1);
            }
        }
        for (int value : map.values()) {
            System.out.print(value + " ");
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

    public static void inorder(Node tree){
        if(tree != null){
            inorder(tree.left);
            System.out.print(tree.data + " ");
            inorder(tree.right);
        }
    }

    public static int height(Node root) {
        // Write your code here.
        if(root == null)return 0;
        else{
            int l = height(root.left);
            int r = height(root.left);
            return Math.max(l, r) + 1;
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

        topView(root);
        System.out.println();
        inorder(root);
        System.out.println();
        System.out.println("Depth tree: " + height(root));
    }
}
