package sort;

import java.util.Random;

public class Main {
    public static int TOTAL_ELEMENT = 100;
    public static int[] A = new int[TOTAL_ELEMENT];
    public static int[] B = new int[TOTAL_ELEMENT];

    public static void initRandom(){
        Random rd = new Random();
        for(int i = 0 ; i < TOTAL_ELEMENT ; i++){
            A[i] = rd.nextInt(TOTAL_ELEMENT);
            B[i] = A[i];
        }
    }

    public static void display(int[] array){
        for(int i = 0 ; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static boolean isGreater(int[] array, int i, int j){
        return array[i] > array[j];
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void bubbleSort(int[] array){
        for(int i = 0 ; i < TOTAL_ELEMENT - 1; i++){
            for (int j = i + 1; j < TOTAL_ELEMENT; j++) {
                if(isGreater(array, i, j)){
                   swap(array, i, j);
                }
            }
        }
    }

    public static void selectedSort(int[] array){
        for (int i = 0; i < TOTAL_ELEMENT; i++) {
            int min = array[i];
            int indexMin = i;
            for (int j = i+1; j <TOTAL_ELEMENT; j++) {
                if(min > array[j]){
                    min = array[j];
                    indexMin = j;
                }
            }
            swap(array, i, indexMin);
        }
    }

    public static void main(String[] args) {
        long start;
        long end;
        initRandom();
        display(A);
        display(B);
        start = System.currentTimeMillis();
        bubbleSort(A);
        end = System.currentTimeMillis();
        display(A);
        System.out.println("Total time of bubble sort is: " + (double)(end - start) / 1000);
        start = System.currentTimeMillis();
        selectedSort(B);
        end = System.currentTimeMillis();
        display(B);
        System.out.println("Total time of bubble sort is: " + (double)(end - start) / 1000);
    }
}
