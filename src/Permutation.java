import java.util.Random;

public class Permutation {
    int[] array;
    void sinh1(int n){
        Random random = new Random(n);
        array = new int[n];
        for (int i = 0; i < n; ) {
            int x = random.nextInt(n) + 1;
            boolean check = true;
            for (int j = 1; j <= i; j++) {
                if(x == array[j]){
                    check = false;
                    break;
                }
            }
            if(check){
                array[i] = x;
                i++;
            }
        }
    }

    void sinh2(int n){
        Random random = new Random();
        boolean[] used = new boolean[n+1];
        array = new int[n];
        array[0] = random.nextInt(n) + 1;
        used[array[0]] = true;
        for (int i = 1; i < n; ) {
            int x = random.nextInt(n) + 1;
            if(!used[x]){
                array[i] = x;
                used[x] = true;
                i++;
            }
        }
    }

    int ranInt(int start, int end){
        Random random = new Random();
        return random.nextInt(end - start  + 1) + start;
    }

    void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    void sinh3(int n){
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = ranInt(0, n);
        }
        for (int i = 1; i < n; i++) {
            swap(array, i, ranInt(0, i));
        }
    }

    void display(){
        for(int item : array){
            System.out.print(item + " ");
        }
    }
    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        permutation.sinh3(10);
        permutation.display();
    }
}
