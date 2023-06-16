package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream input = new FileInputStream(new File("src/practice/solieu.txt"));
        Scanner scanner = new Scanner(input);
        MyLinkedList myLinkedList = new MyLinkedList();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            myLinkedList.add(scanner.nextInt());
        }
        System.out.println("Tổng các nốt lẻ: " + myLinkedList.sumOdd());
        System.out.println("Trung bình cộng các số chẵn: " + myLinkedList.averageEven());
        System.out.println("Đếm số phần tử lớn hơn 3 trong danh sách: " + myLinkedList.countGreaterThanThree());
        System.out.println("Hoán vị phần tử đầu và phần tử cuối trong danh sách: ");
        System.out.println("----Lien ket ban dau");
        myLinkedList.display();
        System.out.println("----Sau khi hoan doi");
        myLinkedList.changeHeadTail();
        myLinkedList.display();
        System.out.println("Giá trị nốt kế cuối trong danh sách: " + myLinkedList.showPreviousTail());
        System.out.println("Đảo danh sách liên kết: ");
        System.out.println("----Liên kết ban đầu");
        myLinkedList.display();
        System.out.println("----Sau khi đảo danh sách: ");
        myLinkedList.reverseLinkList();
        myLinkedList.display();
        System.out.println("Đếm số phần tử khác nhau trong danh sách: " + myLinkedList.countUniqueElement());
    }
}
