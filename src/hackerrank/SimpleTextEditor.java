package hackerrank;

import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = "";
        Stack<String> stack = new Stack<>();
        stack.push(s);

        for (int i = 0; i < n; i++) {
            int type = scanner.nextInt();
            if (type == 1) {
                // append operation
                String w = scanner.next();
                s += w;
                stack.push(s);
            } else if (type == 2) {
                // delete operation
                int k = scanner.nextInt();
                s = s.substring(0, s.length() - k);
                stack.push(s);
            } else if (type == 3) {
                // print operation
                int k = scanner.nextInt();
                System.out.println(s.charAt(k - 1));
            } else if (type == 4) {
                // undo operation
                stack.pop();
                s = stack.peek();
            }
        }

        scanner.close();
    }
}
