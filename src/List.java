import javax.xml.soap.Node;

public class List {
    private class Node{
        int value;
        Node next;

        public Node() {
        }

        public Node(Node next) {
            this.next = next;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    Node head;
    public void addHead(int x){
        System.out.println("Dia chi cua head luc dau: " + head);
        Node newNode = new Node(x, head);
        System.out.println("Dia chi cua node moi: " + newNode);
        head = newNode;
//        head = new Node(x, head);
        System.out.println("Dia chi cua head luc sau: " + head);
        System.out.println("Dia chia cua node next: " + head.next);
    }

    public void display(){
        while (head.next != null){
            System.out.println(head.value);
            head = head.next;
        }
        System.out.println(head.value);
    }

    public static void main(String[] args) {
        List list = new List();
        list.addHead(1);
        System.out.println("=================");
        list.addHead(2);
        System.out.println("=================");
        list.addHead(3);
        System.out.println("=================");
        list.addHead(4);
        System.out.println("=================");
        list.display();
    }

}
