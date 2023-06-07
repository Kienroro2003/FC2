package hackerrank.queue;

import java.util.Scanner;
import java.util.Stack;

public class QueueTwoStacks {
    public class Solution {

        /**
         * 10
         * 1 42
         * 2
         * 1 14
         * 3
         * 1 28
         * 3
         * 1 60
         * 1 78
         * 2
         * 2
         * @param args
         */
        public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner scanner = new Scanner(System.in);
            Stack<Integer> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                int choice = scanner.nextInt();
                switch (choice){
                    case 1:{
                        int itemValue = scanner.nextInt();
                        stack1.push(itemValue);
                        break;
                    }
                    case 2:{
                        if(stack2.isEmpty()){
                            while (!stack1.isEmpty()){
                                stack2.push(stack1.pop());
                            }
                        }
                        stack2.pop();
                        break;
                    }
                    case 3:{
                        if(stack2.isEmpty()){
                            while (!stack1.isEmpty()){
                                stack2.push(stack1.pop());
                            }
                        }
                        System.out.println(stack2.peek());
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution.main(args);
    }
}
