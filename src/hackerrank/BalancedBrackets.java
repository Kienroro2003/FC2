package hackerrank;

import java.io.*;
import java.util.Stack;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        // Write your code here
        Stack<Integer> stack = new Stack<>();
        String[] strings = s.trim().split("");
        for (int i = 0; i < strings.length; i++) {
            int point = 0;
            if(strings[i].equals("(") || strings[i].equals(")")){
                point = 1;
            }
            if(strings[i].equals("{") || strings[i].equals("}")){
                point = 2;
            }
            if(strings[i].equals("[") || strings[i].equals("]")){
                point = 3;
            }
            if(strings[i].equals("(") || strings[i].equals("{") || strings[i].equals("[")){
                stack.push(point);
            }else{
                if( !stack.empty()&& stack.peek() == point ){
                    stack.pop();
                }else{
                    return "NO";
                }
            }
        }
        if(!stack.empty()){
            return "NO";
        }
        return "YES";
    }

}

public class BalancedBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("/Users/kienroro2003/Documents/My MacOS/DuyTan/Fundamentals of Computing/FC2/src/hackerrank/result")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

