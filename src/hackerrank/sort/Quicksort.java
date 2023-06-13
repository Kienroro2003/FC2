package hackerrank.sort;
import java.io.*;
import java.util.*;
import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
        import static java.util.stream.Collectors.toList;

class Result1 {

    /*
     * Complete the 'quickSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> quickSort(List<Integer> arr) {
        int pilotValue = arr.get(0);
        List<Integer> left = new LinkedList();
        List<Integer> right = new LinkedList();
        List<Integer> equal = new LinkedList();
        for(int i = 0 ; i < arr.size(); i++){
            if(pilotValue > arr.get(i)){
                left.add(arr.get(i));
            }else if(pilotValue < arr.get(i)){
                right.add(arr.get(i));
            }else{
                equal.add(arr.get(i));
            }
        }
        List<Integer> res = new LinkedList();
        for(int i = 0 ; i < left.size(); i++){
            res.add(left.get(i));
        }
        for(int i = 0 ; i < equal.size(); i++){
            res.add(equal.get(i));
        }
        for(int i = 0 ; i < right.size(); i++){
            res.add(right.get(i));
        }
        return res;

    }

}

public class Quicksort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result1.quickSort(arr);
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

