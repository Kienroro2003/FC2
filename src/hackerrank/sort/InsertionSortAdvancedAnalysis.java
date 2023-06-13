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

class Result6 {

    /*
     * Complete the 'insertionSort' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static int mergeSortAndCount(List<Integer> arr, int left, int right) {
        int count = 0;

        if (left < right) {
            int mid = (left + right) / 2;
            count += mergeSortAndCount(arr, left, mid);
            count += mergeSortAndCount(arr, mid + 1, right);
            count += merge(arr, left, mid, right);
        }

        return count;
    }

    public static int merge(List<Integer> arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr.get(left + i);
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr.get(mid + 1 + j);
        }

        int count = 0;
        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr.set(k, leftArr[i]);
                i++;
            } else {
                arr.set(k, rightArr[j]);
                j++;
                count += (mid - i + 1);
            }
            k++;
        }

//        while (i < n1) {
//            arr[k] = leftArr[i];
//            i++;
//            k++;
//        }
//
//        while (j < n2) {
//            arr[k] = rightArr[j];
//            j++;
//            k++;
//        }

        return count;
    }

//    public static int insertionSort(List<Integer> arr) {
//        // Write your code here
//        int res = 0;
//        int size = arr.size();
//        for (int i = 1; i < size; i++) {
//            int currentValue = arr.get(i);
//            boolean isChange = false;
//            int count = 0;
//            for (int j = i - 1; j >= 0; j--) {
//                if(currentValue < arr.get(j)){
//                    count++;
//                    arr.set(j + 1, arr.get(j));
//                }else if( currentValue >= arr.get(j)){
//                    arr.set(j + 1, currentValue);
//                    isChange = true;
//                    res += count;
//                    break;
//                }
//            }
//            if(!isChange){
//                arr.set(0, currentValue);
//                res += count;
//            }
//        }
////        System.out.println(arr);
//        return res;
//    }

    public static int insertionSort(List<Integer> arr){
        int size = arr.size();
        int res = mergeSortAndCount(arr,0, size -1);
        return res++;
    }

}

public class InsertionSortAdvancedAnalysis {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                int result = Result6.insertionSort(arr);
                System.out.println(result);
//                bufferedWriter.write(String.valueOf(result));
//                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
//        bufferedWriter.close();
    }
}

