package hackerrank.implementation;
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
public class Result {
    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        // Write your code here
        int nApples = apples.size();
        int nOranges = oranges.size();
        int res = 0;
        for (int i = 0; i < nApples; i++) {
            int total = apples.get(i) + a;
            if(total >= s && total <= t){
                res++;
            }
        }
        System.out.println(res);
        res = 0;
        for (int i = 0; i < nOranges; i++) {
            int total = oranges.get(i) + b;
            if(total <= t && total >= s){
                res++;
            }
        }
        System.out.println(res);
    }

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        final String YES = "YES";
        final String NO = "NO";
        if(x2 >= x1 && v2 > v1)return NO;
        else if(v1 != v2 && ((x2 - x1) % (v1 - v2)) == 0)return YES;
        else return NO;
//        while (x1 < x2){
//            x1 += v1;
//            x2 += v2;
//        }
//        if(x1 == x2)return YES;
//        else return NO;
        // Write your code here
    }

}
