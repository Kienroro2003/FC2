package hackerrank;

import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;


public class QueriesFixedLength {
    public static List<Integer> solve(List<Integer> arr, List<Integer> queries) {
        // Write your code here
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            results.add(0);
        }
        int r = 0;

        for (int q : queries) {
            Deque<Integer> deque = new ArrayDeque<>();
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < q; i++) {
                while (!deque.isEmpty() && arr.get(deque.peekLast()) <= arr.get(i)) {
                    deque.removeLast();
                }
                deque.addLast(i);
            }

            for (int i = q; i < arr.size(); i++) {
                results.set(r, arr.get(deque.peekFirst()));
                if (!deque.isEmpty() && deque.peekFirst() <= i - q) {
                    deque.removeFirst();
                }

                while (!deque.isEmpty() && arr.get(deque.peekLast()) <= arr.get(i)) {
                    deque.removeLast();
                }

                deque.addLast(i);
            }

            results.set(r,Math.max(results.get(r), arr.get(deque.peekFirst())));
            r++;
        }

        return results;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/hackerrank/result"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        List<Integer> queries = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            int queriesItem = Integer.parseInt(bufferedReader.readLine().trim());
            queries.add(queriesItem);
        }

        List<Integer> result = solve(arr, queries);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

