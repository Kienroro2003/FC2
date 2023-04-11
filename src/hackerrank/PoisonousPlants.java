package hackerrank;

import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class PoisonousPlants {
//    public static int poisonousPlants(List<Integer> p) {
//        Stack<Integer> stack = new Stack<>();
//        int days = 0;
//        int min = p.get(0);
//        for (int i = 0; i < p.size(); i++) {
//            int pesticide = p.get(i);
//            if (pesticide > min) {
//                days = Math.max(days, 1);
//            } else {
//                min = pesticide;
//            }
//            while (!stack.isEmpty() && stack.peek() >= pesticide) {
//                if (stack.peek() > pesticide) {
//                    days = Math.max(days, i - stack.pop());
//                } else {
//                    stack.pop();
//                }
//            }
//            stack.push(i);
//        }
//        return days;
//    }
    public static int poisonousPlants(List<Integer> p) {
        int n = p.size();
        int[] days = new int[n];
        int min = p.get(0);
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (p.get(i) > p.get(i - 1)) {
                days[i] = 1;
            }
            min = Math.min(min, p.get(i));
            if (min < p.get(i)) {
                days[i] = Math.max(days[i], days[i - 1] + 1);
            }
            max = Math.max(max, days[i]);
        }
        return max;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/hackerrank/result"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] pTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> p = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pTemp[i]);
            p.add(pItem);
        }

        int result = poisonousPlants(p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

