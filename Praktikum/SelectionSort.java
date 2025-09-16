package Praktikum;

public class SelectionSort {

    public static void sort(int[] arr){
        int i,j,min,temp;
        for (i = 0; i < arr.length-1; i++) {
            min = i;
            for (j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
    public static void main(String[] args) {
        int [] arr = {0,42,5324,5,64,56,3,543,5,34,6,55,47};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
