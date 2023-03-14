import java.util.Random;
import java.util.Scanner;

public class Matrix {
    int[][] matrix;
    int rows, cols;

    public void initMatrix() {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        System.out.println("Enter cols: ");
        cols = sc.nextInt();
        System.out.println("Enter rows: ");
        rows = sc.nextInt();
        matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rd.nextInt(cols * rows) + 1;
            }
        }
    }

    public void outputMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.format("%d\t", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public void maxLine() {
        for (int i = 0; i < rows; i++) {
            int max = matrix[i][0];
            for (int j = 1; j < cols; j++) {
                if (max < matrix[i][j]) {
                    max = matrix[i][j];
                }
            }
            System.out.format("Max line %d: %d\n", i + 1, max);
        }
    }

    public void flipHorizontal() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols / 2; j++) {
                swapMatrix(matrix, i, j);
            }
        }
        outputMatrix();
    }

    private void swapMatrix(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][matrix[i].length - j - 1];
        matrix[i][matrix[i].length - j - 1] = temp;
    }

    public void avgCol() {
        for (int i = 0; i < cols; i++) {
            int sum = 0;
            int count = 0;
            for (int j = 0; j < rows; j++) {
                if (isOdd(matrix[j][i])) {
                    sum += matrix[j][i];
                    count++;
                }
            }
            float avg = (float) sum / count;
            System.out.format("Average of column %d: %.2f\n", i + 1, avg);
        }
    }

    private boolean isOdd(int matrix) {
        return matrix % 2 == 1;
    }

    public void rotateMatrix(){
        int[][] rotateMatrix = new int[cols][rows];
        for (int row = 0; row < rotateMatrix.length ; row++) {
            for (int col = rotateMatrix[0].length - 1; col >= 0 ; col--) {
                rotateMatrix[row][col] = matrix[rows - col - 1][row];
            }
        }
        matrix = rotateMatrix;
        outputMatrix();
    }

    public void rotateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int layers = Math.min(m, n) / 2;
        for (int layer = 0; layer < layers; layer++) {
            int first = layer;
            int last = (n - 1) - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;

                // Lưu trữ các giá trị ở 4 góc của lớp hiện tại
                int top = matrix[first][i];
                int right = matrix[i][last];
                int bottom = matrix[last][last - offset];
                int left = matrix[last - offset][first];

                // Thực hiện xoay các phần tử trong lớp hiện tại bằng cách sử dụng các biến đã lưu trữ
                matrix[first][i] = left;
                matrix[i][last] = top;
                matrix[last][last - offset] = right;
                matrix[last - offset][first] = bottom;
            }
        }
        outputMatrix();
    }

    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        matrix.initMatrix();
        matrix.outputMatrix();
        matrix.maxLine();
        matrix.avgCol();
        matrix.flipHorizontal();
        matrix.rotateMatrix();
    }
}
