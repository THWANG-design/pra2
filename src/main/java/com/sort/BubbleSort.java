package com.sort;

public class BubbleSort {

    public static void bubbleSort(int[]nums){


        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length - i - 1; j++){
                if(nums[j] > nums[j + 1]){
                    swap(nums, j, j + 1);
                }
            }
        }
    }


    public static void swap(int[]nums, int index1, int index2){
        nums[index1] = nums[index1] ^ nums[index2];
        nums[index2] = nums[index2] ^ nums[index1];
        nums[index1] = nums[index1] ^ nums[index2];
    }


    public static void main(String[] args) {
        int[]nums = new int[]{2,6,1,9,2,1};
        bubbleSort(nums);
        for (int num : nums){
            System.out.println(num);
        }
    }
}
