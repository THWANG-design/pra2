package com.sort;

import java.util.Arrays;

public class ChooseSort {

    public static void ChooseSort(int[]num) {

        for(int i = 0; i < num.length; i++){
            int temp = num[i];
            int index = i;
            for(int j = i + 1; j < num.length; j++){
                if(num[j] < temp){
                    i = j;
                }
            }
            num[i] = num[index];
            num[index] = temp;
        }


    }




    public static void main(String[] args) {
        int[]num = new int[]{1,2,4,9};

        ChooseSort(num);
        for(int n : num){
            System.out.println(n);
        }
        System.out.println(num);
        }

}


