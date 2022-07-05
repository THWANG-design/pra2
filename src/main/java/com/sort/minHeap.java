package com.sort;

import jvm.Solution;

public class minHeap {


        public void heapSort(int[]arr){
            buildHeap(arr);
            for(int i = arr.length - 1; i >= 0; i--){
                swap(arr, 0, i);
                heapify(arr, 0, i);
            }
        }

        public void buildHeap(int[]arr){
            for(int i = arr.length / 2 - 1; i >= 0; i--){
                heapify(arr, i, arr.length);
            }
        }

        public void heapify(int[]arr, int i, int length){
            int left = 2 * i + 1;
            int right = left + 1;
            int largest = i;

            if(left < length && arr[left] > arr[largest]){
                largest = left;
            }
            if(right < length && arr[right] > arr[largest]){
                largest = right;
            }

            if(largest != i){
                swap(arr,i, largest);
                heapify(arr, largest, length);
            }

        }



        public void swap(int[]nums, int a, int b){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }


    }

class Main{
    public static void main(String[] args) {
        minHeap m = new minHeap();
        int[]nums = new int[]{1,23,5,2,1,6,43,2};
        m.heapSort(nums);
        for(int num : nums){
            System.out.println(num);
        }
    }
}
