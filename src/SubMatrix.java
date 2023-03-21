import java.util.Random;
import java.util.Scanner;

public class SubMatrix {
    private int[][] matrix;
    private int cols;
    private int rows;
    public void input(){
        Random rd = new Random(new Random().nextInt());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter rows: ");
        this.rows = scanner.nextInt();
        System.out.println("Enter columns: ");
        this.cols = scanner.nextInt();
        this.matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = rd.nextInt(cols * rows) + 1;
            }
        }
    }

    public void output(){
        System.out.println("Display: ");
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.format("%d\t", matrix[row][col] );
            }
            System.out.println();
        }
    }

    public SubMatrix multiplyMatrix(SubMatrix paramMatrix){
        if (this.cols != paramMatrix.rows){
            System.out.println("Doesn't meet the condition");
            return null;
        }else{
            SubMatrix result = new SubMatrix();
            result.matrix = new int[this.rows][paramMatrix.cols];
            result.rows = this.rows;
            result.cols = paramMatrix.cols;
            for (int row = 0; row < result.rows; row++) {
                for (int col = 0; col < result.cols; col++) {
                    result.matrix[row][col] = 0;
                    for (int q = 0; q < this.cols; q++) {
                        result.matrix[row][col] += this.matrix[row][q] *  paramMatrix.matrix[q][col];
                    }
                }
            }
            return result;
        }

    }

    public static void main(String[] args) {
        SubMatrix A = new SubMatrix();
        SubMatrix B = new SubMatrix();
        A.input();

        B.input();
        A.output();
        B.output();
        SubMatrix C = A.multiplyMatrix(B);
       if(C != null){
           C.output();
       }else{
           System.out.println("Cc");
       }
    }
}
