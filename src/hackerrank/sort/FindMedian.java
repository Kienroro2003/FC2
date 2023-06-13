package hackerrank.sort;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result5 {

    /*
     * Complete the 'findMedian' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static int partition(List<Integer> arr, int left, int right) {
        int start = left;
        int end = right + 1;
        int pilot = arr.get(left);
        while (start < end) {
            start++;
            while (start <= right && arr.get(start) < pilot) start++;
            end--;
            while (end >= left && arr.get(end) > pilot) end--;
            Collections.swap(arr, start, end);
        }
        Collections.swap(arr, start, end);
        Collections.swap(arr, end, left);
        return end;
    }

    public static void quickSort(List<Integer> arr, int left, int right) {
        if (left < right) {
            int pilot = partition(arr, left, right);
            if (left < pilot) {
                quickSort(arr, left, pilot - 1);
            }
            if (right > pilot) {
                quickSort(arr, pilot + 1, right);
            }
        }
    }

    public static int findMedian(List<Integer> arr) {
        // Write your code here
        int size = arr.size();
        quickSort(arr, 0, size - 1);
        return arr.get(size / 2);
    }

}

public class FindMedian {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result5.findMedian(arr);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}

