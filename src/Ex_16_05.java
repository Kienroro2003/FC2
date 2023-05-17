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

    public int il(Node root){
        if(root == null){
            return 0;
        }else if(root.left == null && root.right == null){
            return 1;
        }else{
            return il(root.left) + il(root.right);
        }
    }

//    public int sumOdd(Node root, int total){
//        if(root != null){
//            return  sumOdd(root.left, total) + sumOdd(root.right, total);
//        }else{
//
//        }
//    }

    public int deepNode(Node root){
        if(root == null)return 0;
        else return 1 + Math.max(deepNode(root.left), deepNode(root.right));
    }

    public int deepNode(Node root, int value , int k){
        if(root == null){
            return -1;
        }
        if(root.value == value){
            return k;
        }
        int leftLevel = deepNode(root.left, value, k + 1);
        if (leftLevel != -1)
            return leftLevel;

        int rightLevel = deepNode(root.right, value, k + 1);
        return rightLevel;
    }

    /**
     * In tất cả các nốt thứ k
     * @param root: tree
     * @param k: mức cần in
     */
    public void displayDeepNode(Node root, int k){
        if(root != null){
            displayDeepNode(root.left, k - 1 );
            displayDeepNode(root.right, k - 1);
            if(k == 0){
                System.out.print(root.value + " ");
            }
        }
    }

    public int countK(Node root, int k){
        if(root == null)return 0;
        if(k == 0)return 1;
        else{
            int l = countK(root.left, k - 1);
            int r = countK(root.right, k - 1);
            return l + r;
        }
    }

    public int totalK(Node root, int k){
        if(root == null)return 0;
        if(k == 0)return root.value;
        else{
            int l = totalK(root.left, k - 1);
            int r = totalK(root.right, k - 1);
            return l + r;
        }
    }

    /**
     * tìm mức có nhiều nốt nhất
     * @param root: tree
     * @return mức có nhiều nốt nhất
     */
    public int maxDeepNode(Node root){
        int height = deepNode(root);
        int result = -1;
        int total = -1;
        for (int i = 0; i < height; i++) {
            int temp = countK(root, i);
            if(temp > total){
                total = temp;
                result = i;
            }
        }

        return result;
    }

    /**
     * Mức có tổng các nốt lớn nhất
     * @param root: tree
     * @return mức có tổng lớn nhất
     */
    public int maxDeep(Node root){
        int height = deepNode(root);
        int total = -1;
        for (int i = 0; i < height; i++) {
            int temp = totalK(root, i);
            if(temp > total){
                total = temp;
            }
        }

        return total;
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
        System.out.println("Deep of tree: " + ex1605.deepNode(ex1605.root));
        System.out.println("Total of the leaf: " + ex1605.il(ex1605.root));
        System.out.println("Deep of node 3: " + ex1605.deepNode(ex1605.root, 7, 0));
        System.out.println("Tong so node: " + ex1605.countK(ex1605.root, 0));
        System.out.println("Do sau cua cay co nhieu node nhat: " + ex1605.maxDeepNode(ex1605.root));
        System.out.println("Tong cua cac node co do sau nhat: " + ex1605.maxDeep(ex1605.root));
        ex1605.displayDeepNode(ex1605.root, 2);
    }
}
