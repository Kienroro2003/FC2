import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int g = sc.nextInt();

        while (g-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int maxSum = sc.nextInt();

            int[] a = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                a[i] = sc.nextInt();
            }

            int[] b = new int[m];
            for (int i = m - 1; i >= 0; i--) {
                b[i] = sc.nextInt();
            }

            // prefix sum of each stack
            int[] prefixA = prefixSum(a);
            int[] prefixB = prefixSum(b);

            int maxScore = 0;

            // loop through all possible combinations of removing elements
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    int sumA = i == 0 ? 0 : prefixA[i - 1];
                    int sumB = j == 0 ? 0 : prefixB[j - 1];
                    int score = i + j;
                    if (sumA + sumB <= maxSum && score > maxScore) {
                        maxScore = score;
                    }
                }
            }

            System.out.println(maxScore);
        }

        sc.close();
    }

    // compute the prefix sum of an array
    private static int[] prefixSum(int[] a) {
        int n = a.length;
        int[] prefix = new int[n];
        for (int i = 0; i < n; i++) {
            prefix[i] = i == 0 ? a[i] : prefix[i - 1] + a[i];
        }
        return prefix;
    }
}
