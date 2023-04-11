package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MaximumElement {
    public static List<Integer> getMax(List<String> operations) {
        // Write your code here
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        for (String str :
                operations) {
            String[] strings = str.split(" ");
            switch (strings[0]){
                case "1":{
                    int x = Integer.parseInt(strings[1]);
                    stack.add(x);
                    if(maxStack.isEmpty() || maxStack.peek() < x){
                        maxStack.push(x);
                    }
                    break;
                }
                case "2":{
                    if (!stack.isEmpty()) {
                        int popped = stack.pop();
//                        if (popped == maxStack.peek()) {
//                            maxStack.pop();
//                        }
                    }
                    break;
                }
                case "3":{
                    System.out.println(maxStack.peek());
                    break;
                }
            }
        }
        return maxStack;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/hackerrank/result"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String opsItem = bufferedReader.readLine();
            ops.add(opsItem);
        }

        List<Integer> res = getMax(ops);

        for (int i = 0; i < res.size(); i++) {
            bufferedWriter.write(String.valueOf(res.get(i)));

            if (i != res.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

