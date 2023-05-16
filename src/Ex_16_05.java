public class Ex_16_05 {
    private class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    Node root;

    public void init(){
        root = new Node(3, new Node(6, new Node(1), new Node(7, null, new Node(2))), new Node(8, new Node(4,null, new Node(6)),new Node(9)));
    }
    public void preOrder(Node root){
        if(root != null){
            System.out.print(root.value + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder(Node root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.value + " ");
            inOrder(root.right);
        }
    }

    public void postOrder(Node root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.value + " ");
        }
    }
    public static void main(String[] args) {
        Ex_16_05 ex1605 = new Ex_16_05();
        ex1605.init();
        ex1605.preOrder(ex1605.root);
        System.out.println();
        ex1605.inOrder(ex1605.root);
        System.out.println();
        ex1605.postOrder(ex1605.root);
        System.out.println();
    }
}
