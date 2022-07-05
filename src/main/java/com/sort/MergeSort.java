package com.sort;

public class MergeSort {

    public void mergeSort(int[]arr) {
        int[]res = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, res);

    }

    public void mergeSort(int[]arr, int start, int end, int[]res) {
        if(start == end)
            return;
        int middle = (end - start) / 2 + start;

        mergeSort(arr, start, middle, res);
        mergeSort(arr, middle + 1, end, res);
        merge(arr, start, end, res);

    }

    public void merge(int[]arr, int start, int end, int[]res) {
        int start1 = start;
        int end1 = (end - start) / 2 + start;
        int start2 = end1 + 1;
        int end2 = end;
        int index = start;

        while(start1 <= end1 && start2 <= end2){
            if(arr[start1] <= arr[start2]){
                res[index++] = arr[start1++];
            }
            else{
                res[index++] = arr[start2++];
            }
        }

        while(start1 <= end1){
            res[index++] = arr[start1++];
        }
        while(start2 <= end2){
            res[index++] = arr[start2++];
        }

        for(int i = start; i <= end; i++){
            arr[i] = res[i];
        }

    }




    public static void main(String[] args) {
        MergeSort s = new MergeSort();
        int[]res = new int[]{32,1,4,8,2,1,24,4};
        s.mergeSort(res);
        for(int num:res){
            System.out.println(num);
        }
    }
}
