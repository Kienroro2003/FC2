package hackerrank.array;
import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class Array2D {
    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here
        /**
         * static int hourglassSum(int[][] arr) {
         *     int maxSum = Integer.MIN_VALUE;
         *     for (int i = 0; i <= arr.length - 3; i++) {
         *         for (int j = 0; j <= arr[0].length - 3; j++) {
         *             int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2]
         *                     + arr[i+1][j+1]
         *                     + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
         *             maxSum = Math.max(maxSum, sum);
         *         }
         *     }
         *     return maxSum;
         * }
         */
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i <= arr.size() - 3; i++) {
            for (int j = 0; j <= arr.get(0).size() - 3; j++) {
                int sum = arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2) + arr.get(i + 1).get(j + 1) + arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2);
                maxSum = Math.max(sum, maxSum);
            }

        }
        return maxSum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/hackerrank/array/data/data"));

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

