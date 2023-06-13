package hackerrank.sort;
import java.io.*;
import java.util.*;
import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
        import static java.util.stream.Collectors.toList;

class Result2 {

    /*
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> countingSort1(List<Integer> arr) {
        // Write your code here
        int size = arr.size();
        List<Integer> frequencies = new ArrayList<>(Collections.nCopies(100, 0));
        for (int i = 0; i < size; i++) {
            int value = arr.get(i);
            frequencies.set(value, frequencies.get(value) + 1);
        }
        return frequencies;
    }

    public static List<Integer> countingSort2(List<Integer> arr) {
        // Write your code here
        List<Integer> frequencies = countingSort1(arr);
        List<Integer> sortedArray = new ArrayList<>();
        for(int i = 0; i < frequencies.size(); i++){
            if(frequencies.get(i) != 0){
                sortedArray.add(i);
                frequencies.set(i, frequencies.get(i) - 1);
                i--;
            }
        }
        return sortedArray;
    }

}

public class CountingSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result2.countingSort2(arr);
        System.out.println(result);
//        bufferedWriter.write(
//                result.stream()
//                        .map(Object::toString)
//                        .collect(joining(" "))
//                        + "\n"
//        );

        bufferedReader.close();
//        bufferedWriter.close();
    }
}

