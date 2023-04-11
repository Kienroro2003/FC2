package hackerrank;
import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;



public class LargestRectangle {
    public static long largestRectangle(List<Integer> h) {
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;
        int i = 0;
        while (i < h.size()) {
            if (stack.isEmpty() || h.get(stack.peek()) <= h.get(i)) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                long area = (long) h.get(top) * (stack.isEmpty() ? i : i - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            long area = (long) h.get(top) * (stack.isEmpty() ? i : i - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/hackerrank/result"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] hTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hTemp[i]);
            h.add(hItem);
        }

        long result = largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

