public class headSort {
    public void headSort(int[] arr){
        buildMaxHeap(arr);

        for(int i = arr.length - 1; i > 0 ; i --){
            swap(arr, 0 , i);
            MaxHeap(arr, 0, i);                         //对剩下的继续进行排序；

        }
    }

    public void buildMaxHeap(int[] arr){
        for(int i =  arr.length /2 - 1 ; i >=0 ; i--){
            MaxHeap(arr, i, arr.length);
        }
    }

    public void MaxHeap(int[] arr, int i, int size) {    //对三个点进行排序
        int l = 2* i + 1;
        int r = l + 1;
        int largest = i;

        if(l < size && arr[l] > arr[largest]) largest = l;
        if(r < size && arr[r] > arr[largest]) largest = r;

        if(largest != i){
            swap(arr, largest, i);
            MaxHeap(arr, largest, size);
        }



    }

    public void swap(int[] arr, int x, int y){
        x = x ^ y;
        y=x ^ y ;
        x=x ^ y;

    }
}
