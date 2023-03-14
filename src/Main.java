import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random1 = new Random(3);
        Random random2 = new Random();
        System.out.print("Co neo(gia tri random khong doi): ");
        for (int i = 0; i < 5; i++) {
            System.out.print(random1.nextInt(100) + " ");
        }
        System.out.println();
        System.out.print("Khong neo(gia tri random thay doi): ");
        for (int i = 0; i < 5; i++) {
            System.out.print(random2.nextInt(100) + " ");
        }
    }
}
