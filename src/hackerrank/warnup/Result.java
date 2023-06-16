package hackerrank.warnup;
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

import java.util.List;

public class Result {

    /*
     * Complete the 'simpleArraySum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY ar as parameter.
     */

    public static int simpleArraySum(List<Integer> ar) {
        // Write your code here
        int res = 0;
        for (int i = 0; i < ar.size(); i++) {
            res += ar.get(i);
        }
        return res;
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        System.out.println(arr);
        // Write your code here
        int size = arr.size();
        int leftDiagonal = 0;
        int rightDiagonal = 0;
        for(int i = 0 ; i < size; i++){
            leftDiagonal += arr.get(i).get(i);
            rightDiagonal += arr.get(i).get(size - i - 1);
        }
        return Math.abs(leftDiagonal - rightDiagonal);
    }

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        long maximum = 0;
        long minimum = 0;
        int size = arr.size();
        for(int i = 0 ; i < 4; i++){
            maximum += arr.get(size - i - 1);
            minimum += arr.get(i);
        }
        System.out.println(minimum + " " + maximum);
    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here
        int size = candles.size();
        int max = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0 ; i < size; i++){
            if(max < candles.get(i)){
                max = candles.get(i);
                count = 1;
            }else if (max == candles.get(i)){
                count++;
            }
        }
        return count;

    }
    public static String timeConversion(String s) {
        // Write your code here
        String am = s.substring(8);
        if (am.equals("AM")) {
            int hour = Integer.parseInt(s.substring(0, 2));
            if(hour == 12){
                return "00" + s.substring(2,8);
            }
            return s.substring(0, 8);
        } else {
            int hour = Integer.parseInt(s.substring(0, 2));
            if(hour < 12){
                hour += 12;
            }
            String other = s.substring(2, 8);
            if (hour == 24) {
                return "00" + other;
            }
            return hour + other;

        }
//        System.out.println(s.substring(8));

    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        int size = grades.size();
        for(int i = 0 ;i < size; i++){
            int currentGrade = grades.get(i);
            if(currentGrade < 37){
                continue;
            }
            for (int j = 0; j < 3; j++) {
                if((currentGrade + j) % 5 == 0){
                    grades.set(i , currentGrade + j);
                    break;
                }
            }
        }
        return grades;
    }


}
