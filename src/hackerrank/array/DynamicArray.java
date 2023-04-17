package hackerrank.array;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class DynamicArray {
    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // Write your code here
        List<Integer> ans = new ArrayList<>();
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        int lastAns = 0;
        for (int i = 0; i < queries.size(); i++) {
            if(queries.get(i).get(0) == 1){
                int idx = (queries.get(i).get(1) ^ lastAns) % n;
                if(idx == 0){
                    arr1.add(queries.get(i).get(2));
                }else{
                    arr2.add(queries.get(i).get(2));
                }
            }
            if(queries.get(i).get(0) == 2){
                int idx = (queries.get(i).get(1) ^ lastAns) % n;

                if(idx == 0){
                    lastAns = arr1.get(queries.get(i).get(2) % arr1.size());
                    ans.add(arr1.get(arr1.size() - 1));
                }else{
                    lastAns = arr2.get(queries.get(i).get(2) % arr2.size());
                    ans.add(arr2.get(arr2.size() - 1));
                }
            }
        }
        System.out.println(arr1);
        System.out.println(arr2);
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/hackerrank/array/data/data"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            String[] queriesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> queriesRowItems = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowTempItems[j]);
                queriesRowItems.add(queriesItem);
            }

            queries.add(queriesRowItems);
        }

        List<Integer> result = dynamicArray(n, queries);

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
