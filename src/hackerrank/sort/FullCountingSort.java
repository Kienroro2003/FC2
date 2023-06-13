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

class Result3 {

    /*
     * Complete the 'countSort' function below.
     *
     * The function accepts 2D_STRING_ARRAY arr as parameter.
     */

    public static void countSort(List<List<String>> arr) {
        // Write your code here
        int size = arr.size();
        List<Integer> frequencies = new ArrayList<>(Collections.nCopies(size, 0));
        for(int i = 0 ; i < size; i++){
            List<String> temp = arr.get(i);
            if(i < size / 2){
                temp.set(1, "-");
            }
            int index = Integer.parseInt(temp.get(0));
            frequencies.set(index, frequencies.get(index) + 1);
        }
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            res.add(new ArrayList<>());
        }
        for(int i = 0 ; i < size; i++){
            List<String> temp = arr.get(i);
            int index = Integer.parseInt(temp.get(0));
            if(frequencies.get(index) != 0){
                res.get(index).add(temp.get(1));
                frequencies.set(index, frequencies.get(index) - 1);
            }
        }
        for(int i = 0; i < size; i++){
            if(res.get(i).isEmpty())continue;
            else{
                for (int j = 0; j < res.get(i).size(); j++) {
                    System.out.print(res.get(i).get(j));
                    if(j < res.get(i).size() - 1){
                        System.out.print(" ");
                    }
                }

            }
            if (i < size - 1){
                System.out.print(" ");
            }
        }
    }

}

public class FullCountingSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result3.countSort(arr);

        bufferedReader.close();
    }
}


