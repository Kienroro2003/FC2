package hackerrank;
import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;


public class Waiter {
    public static List<Integer> waiter(List<Integer> number, int q) {
        List<Integer> primes = new ArrayList<>();
        List<Integer> answers = new ArrayList<>();
        Stack<Integer> A = new Stack<>();
        Stack<Integer> B = new Stack<>();

        // find the first q primes
        int i = 1;
        while (primes.size() < q) {
            if (isPrime(i)) {
                primes.add(i);
            }
            i++;
        }

        // perform q iterations
        for (i = 0; i < q; i++) {
            while (!number.isEmpty()) {
                int plate = number.remove(0);
                if (plate % Math.pow(primes.get(i), i+1) == 0) {
                    B.push(plate);
                } else {
                    A.push(plate);
                }
            }
            while (!B.isEmpty()) {
                answers.add(B.pop());
            }
            // swap stacks A and B
            Stack<Integer> temp = A;
            A = B;
            B = temp;
        }
        while (!A.isEmpty()) {
            answers.add(A.pop());
        }
        return answers;
    }

    // helper function to check if a number is prime
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/hackerrank/result"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        String[] numberTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> number = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int numberItem = Integer.parseInt(numberTemp[i]);
            number.add(numberItem);
        }

        List<Integer> result = waiter(number, q);

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


