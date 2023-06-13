package hackerrank.sort;
import java.io.*;
import java.util.*;
import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
        import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        for(int i = 0 ; i < n ; i++){
            int currentValue = arr.get(i);
            boolean isChanging = false;
            for(int j = n - 1; j > 0; j--){
                if(currentValue < arr.get(j - 1)){
                    arr.set(j, arr.get(j - 1));
                    display(n, arr);
                }else{
                    arr.set(j, currentValue);
                    display(n, arr);
                    isChanging = true;
                    break;
                }
            }
            if(!isChanging){
                arr.set(0, currentValue);
                display(n, arr);
            }
        }
    }

    public static void insertionSort2(int n, List<Integer> arr){
        for(int i = 1 ; i < n ; i++){
            int currentValue = arr.get(i);
            boolean isChanging = false;
            for(int j = i; j > 0; j--){
                int lowerValue = arr.get(j - 1);
                if(currentValue < lowerValue){
                    arr.set(j, lowerValue);
                }else if (currentValue > lowerValue){
                    arr.set(j, currentValue);
                    isChanging = true;
                    break;
                }
            }
            if(!isChanging){
                arr.set(0, currentValue);
//                display(n, arr);
            }
//            display(n, arr);
        }
    }

    public static void display(int n, List<Integer> arr){
        for(int i = 0 ; i < n ; i++){
            System.out.print(arr.get(i));
            if(i != n - 1){
                System.out.print(" ");
            }
        }
        System.out.println();
    }

}

public class InsertionSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.insertionSort2(n, arr);
//        System.out.println(arr.toString());
        Result.display(n, arr);
        bufferedReader.close();
    }
}

