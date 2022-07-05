import java.util.HashMap;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        String[] result = new String[score.length ];
        for(int i = 0; i < score.length; i ++){
            map.put(score[i], i);
        }
        headSort(score);
        for (int i = 0; i < score.length; i++) {
            System.out.println(score[i]);

        }
        int index = map.get(score[0]);

        result[index] = "Gold Medal";
        int index2 = map.get(score[1]);
        result[index2] = "Silver Medal";
        int index3 = map.get(score[2]);
        result[index3] = "Bronze Medal";

        for(int i = 3; i < score.length; i++){
            int indexOther = map.get(score[i]);
            result[indexOther] = Integer.toString(i+1);
        }
        return result;

    }
    public void headSort(int[] arr){
        buildHeadSort(arr);
        for(int i = 1; i <arr.length ; i++){
            maxHead(arr, i, arr.length);
        }
    }
    public void buildHeadSort(int[] arr){
        int n = arr.length;
        for(int i = n / 2 - 1; i >= 0 ; i--){
            maxHead(arr, i, arr.length );
        }
    }
    public void maxHead(int[] arr, int i , int size){
        int l = 2*i + 1;
        int r = l + 1;
        int largest = i;
        if( l < size && arr[l] > arr[largest])
            largest = l;
        if(r < size && arr[r] > arr[largest])
            largest = r;
        if(largest != i){
            swap(arr, i , largest);
            maxHead(arr, largest, size);
        }
    }

    public void swap(int[] arr, int i ,  int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];

    }


}
