package com.sort;

public class QuickSort {

    public void quickSort(int[]arr){
        quickSort(arr,0, arr.length - 1);
    }

    public void quickSort(int[]arr, int left, int right){
        if(left >= right)
            return;
        int middle = partition(arr, left, right);

        quickSort(arr, left, middle - 1);
        quickSort(arr, middle + 1, right);
    }


    public int partition(int[]arr, int left, int right){
        int start = left;
        int pivot = arr[start];
        left += 1;
        while(left < right){
            while(left < right && arr[left] <= pivot){
                left++;
            }
            while(left < right && arr[right] >= pivot){
                right--;
            }
            if(left < right){
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        if(left == right && arr[right] > pivot)
            right--;
        swap(arr, start, right);
        return right;
    }

    public void swap(int[]arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }






}


class MainSolution{
    public static void main(String[] args) {
        QuickSort s = new QuickSort();
        int[]nums = new int[]{1,2,78,1,2,4,2,1,64};
        s.quickSort(nums);
        for (int num : nums){
            System.out.println(num);
        }

    }

}


