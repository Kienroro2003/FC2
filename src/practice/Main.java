package practice;


import java.io.File;
        import java.io.FileNotFoundException;
        import java.util.HashSet;
        import java.util.Scanner;
        import java.util.Set;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int sumOddNumbers() {
        int sum = 0;
        Node current = head;
        while (current != null) {
            if (current.data % 2 != 0) {
                sum += current.data;
            }
            current = current.next;
        }
        return sum;
    }

    public double averageEvenNumbers() {
        int count = 0;
        int sum = 0;
        Node current = head;
        while (current != null) {
            if (current.data % 2 == 0) {
                count++;
                sum += current.data;
            }
            current = current.next;
        }
        if (count == 0) {
            return 0;
        }
        return (double) sum / count;
    }

    public int countElementsGreaterThan3() {
        int count = 0;
        Node current = head;
        while (current != null) {
            if (current.data > 3) {
                count++;
            }
            current = current.next;
        }
        return count;
    }

    public int countUniqueElements() {
        Set<Integer> uniqueElements = new HashSet<>();
        Node current = head;
        while (current != null) {
            uniqueElements.add(current.data);
            current = current.next;
        }
        return uniqueElements.size();
    }

    public void swapFirstAndLast() {
        if (head == null || head.next == null) {
            return;
        }
        Node current = head;
        Node prev = null;
        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        int temp = head.data;
        head.data = current.data;
        current.data = temp;
    }

    public void printSecondLastNode() {
        if (head == null || head.next == null) {
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        System.out.println("Second Last Node: " + current.next.data);
    }

    public void reverseList() {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        head = prev;
    }
}

public class Main {
    public static void main(String[] args) {
        File file = new File("src/practice/solieu.txt");
        try {
            Scanner scanner = new Scanner(file);
            int n = scanner.nextInt();

            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < n; i++) {
                int data = scanner.nextInt();
                linkedList.addNode(data);
            }

            System.out.print("Danh sách ban đầu: ");
            linkedList.printList();

            int sumOdd = linkedList.sumOddNumbers();
            System.out.println("Tổng các số lẻ: " + sumOdd);

            double averageEven = linkedList.averageEvenNumbers();
            System.out.println("Trung bình cộng các số chẵn: " + averageEven);

            int countGreaterThan3 = linkedList.countElementsGreaterThan3();
            System.out.println("Số phần tử lớn hơn 3: " + countGreaterThan3);

            int countUnique = linkedList.countUniqueElements();
            System.out.println("Số phần tử khác nhau: " + countUnique);

            linkedList.swapFirstAndLast();
            System.out.print("Danh sách sau khi hoán vị phần tử đầu và cuối: ");
            linkedList.printList();

            linkedList.printSecondLastNode();

            linkedList.reverseList();
            System.out.print("Danh sách sau khi đảo ngược: ");
            linkedList.printList();

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}