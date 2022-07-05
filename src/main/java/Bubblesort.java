import java.lang.reflect.Array;
import java.util.Arrays;

public class Bubblesort {

    public  void BubbleSort(int [] array){
        for (int i = 0 ; i < array.length - 1 ; i ++){
            for(int j = 0 ; j < array.length - 1 - i ; j ++){
                if(array[j] >= array[j + 1])
                    swap(array, j , j+1);
            }
        }
    }

    public void bubbleSort(int[] array){
        boolean swicth = true;
        for(int i = 0; i < array.length - 1; i ++){
            if(!swicth) break;
            swicth = false;
            for(int j = 0 ; j < array.length - 1 - i; j++){
                if(array[j] > array[j+1]){
                    swap(array, j, j+1);
                    swicth = true;
                }
            }
        }
    }

    public  void swap(int [] array, int i , int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }


    //###########################################################################//


    public void test(){
        int []array = {1, 6, 8 ,4, 5, 1, 3};
        bubbleSort(array);
        String s = Arrays.toString(array);
        System.out.println(s);

    }

    public  void main(String[] args) {
        test();
    }

}
