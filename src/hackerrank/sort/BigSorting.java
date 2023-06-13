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

class Result {

    /*
     * Complete the 'bigSorting' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY unsorted as parameter.
     */

    public static List<String> bigSorting(List<String> unsorted) {
        // Write your code here
        int size = unsorted.size();
        for (int i = 1; i < size; i++) {
            String currentValue = unsorted.get(i);
            boolean isChange = false;
            for (int j = i - 1; j >= 0; j--) {
                String nestedValue = unsorted.get(j);
                if(currentValue.length() < nestedValue.length()){
                    unsorted.set(j + 1, unsorted.get(j));
                }else if(currentValue.length() > nestedValue.length()){
                    unsorted.set(j + 1, currentValue);
                    isChange = true;
                    break;
                }else{
                    int diff = currentValue.compareTo(nestedValue);
//                    System.out.format("%s compare %s = %d\n", currentValue, nestedValue, diff);
                    if(diff < 0){
                        unsorted.set(j + 1, unsorted.get(j));
                    }else if(diff >= 0){
                        unsorted.set(j + 1, currentValue);
                        isChange = true;
                        break;
                    }
                }
            }
            if(!isChange){
                unsorted.set(0, currentValue);
            }
        }
        return unsorted;
    }

}

public class BigSorting {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> unsorted = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = Result.bigSorting(unsorted);
        System.out.println(result);

//        bufferedWriter.write(
//                result.stream()
//                        .collect(joining("\n"))
//                        + "\n"
//        );

        bufferedReader.close();
//        bufferedWriter.close();
    }
}

