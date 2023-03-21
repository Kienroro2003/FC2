import java.util.Random;
import java.util.Scanner;

public class Matrix {
    int[][] matrix; // biến matrix đại diện cho mảng 2 chiều
    int rows; // đại diện cho số lượng hàng
    int cols; // đại diện cho số lượng

    /**
     * hàm này có chức năng khởi tạo mảng
     * và sinh số ngẫu nhiên cho các phần từ của mảng 2 chiều
     */
    public void inputMatrix(){
        Scanner scanner = new Scanner(System.in); // khởi tạo đối tượng Scanner
        Random random = new Random(1);// khởi tạo đối tượng Random với mỏ neo là 1
        System.out.println("Nhập số lượng hàng: ");
        rows = scanner.nextInt(); // nhập số lượng hàng
        System.out.println("Nhập số lượng cột: ");
        cols = scanner.nextInt(); // nhập số lượng cột
        matrix = new int[rows][cols]; // khởi tạo mảng 2 chiều với rows hàng và cols cột
        for(int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++) {
                System.out.format("Vị trí hàng là %d, vị trí cột là %d\n", row, col);
                matrix[row][col] = random.nextInt(rows * cols) + 1;
            }
        }
    }

    /**
     * hàm này tìm và in giá trị của phần tử cần tìm
     */
    public void find(){
        Scanner scanner = new Scanner(System.in); // khởi tạo đối tượng Scanner
        System.out.println("Nhập vị trí hàng: ");
        int row = scanner.nextInt(); // nhập vị hàng cần tìm
        System.out.println("Nhập vị trí cột: ");
        int col = scanner.nextInt(); // nhập vị trí cột cần tìm
        System.out.format("Giá trị của phần tử tại vị trí hàng %d cột %d là %d", row, col, matrix[row][col]); // in
    }

    public void outputMatrix(){
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.format("%d\t", matrix[row][col]);
            }
        }
    }

    public static void main(String[] args) {
        Matrix matrix = new Matrix(); // khởi tạo đối tượng Matrix với tên biến là matrix
        matrix.inputMatrix(); // gọi hàm inputMatrix
    }
}
