import java.util.Arrays;

public class SelectionSort {

    public int selectionSort1(int arr[]) {
        int minIndex = 0;
        int counti = 0;
        int countj = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            counti++;
            for (int j = i; j < arr.length; j++) {
                countj++;
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, minIndex, i);

        }
        return counti + countj;
    }

    public int selectionSort2(int [] arr){
        int minIndex = 0;
        int maxIndex = 0;
        int counti = 0;
        int countj = 0;
        for (int i = 0; i < arr.length /2 ; i++) {
            minIndex = i;
            maxIndex = i;
            counti++;
            for (int j = i + 1; j < arr.length - i; j++) {
                if(arr[maxIndex] < arr[j]){
                    maxIndex = j;
                }
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
                countj += 2;
            }
            if(maxIndex == minIndex) break;
            swap(arr,i, minIndex );

            int currentLastIndex = arr.length - i - 1;
            if(maxIndex == i) maxIndex = minIndex;
            swap(arr, maxIndex, currentLastIndex);



        }
        return counti + countj;
    }

    public  void swap(int [] array, int i , int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 9, 11, 85, 4156, 1223, 51, 123};
        SelectionSort c1 = new SelectionSort();
        int s2 =  c1.selectionSort2(arr);
        int s1 = c1.selectionSort1(arr);
        System.out.println(s1);
        System.out.println(s2);
    }






}
