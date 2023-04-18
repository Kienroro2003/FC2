package hackerrank.array;

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

public class ArrayManipulation {
    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // Write your code here
        int w = 0;
        int h = queries.size();
        for (int i = 0; i < queries.size(); i++) {
            for (int j = 0; j < queries.get(i).size(); j++) {
                if(queries.get(i).get(j) > w){
                    w = queries.get(i).get(j);
                }
            }
        }
        List<List<Integer>> list =  new ArrayList<>();
        for (int i = 0; i < h; i++) {
            List<Integer> row = Arrays.asList(new Integer[w]);
            Collections.fill(row, 0);
            list.add(row);
        }
        for (int i = 0; i < queries.size(); i++) {
            int start = queries.get(i).get(0);
            int end = queries.get(i).get(1);
            long value = queries.get(i).get(2);
            for (int j = 0; j < list.size(); j++) {
                for (int k = 0; k < list.get(j).size(); k++) {
                    if(list.get(j).get(k) != 0){
                        long curValue = list.get(j).get(k);

                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = arrayManipulation(n, queries);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
