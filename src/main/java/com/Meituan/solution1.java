package com.Meituan;

import java.util.Arrays;

public class solution1 {

    public static int findMaxSize(int[]array, int size){
        Arrays.sort(array);
        int[]dp = new int[array.length];
        dp[0] = 1;
        int temp = array[1] - array[0];
        if(temp > 1)
            dp[1] = 2;
        else
            dp[1] = 1;
        for(int i = 2; i < array.length; i++){
            if(array[i] - array[i-1] > 1)
                dp[i] = dp[i-1] + 1;
            else if(array[i] == array[i-1])
                dp[i] = dp[i-1];
            else{
                int prev = i-1;
                while(prev >0 && array[prev] == array[i-1]){
                    prev--;
                }
                dp[i] = Math.max(dp[i-1], dp[prev] + 1);
            }
        }

        return dp[array.length - 1];

    }

    public static void main(String[] args) {
        int[]array = new int[]{1,2,3,5,6,7};
        int size = 6;
        int res = findMaxSize(array,size);
        System.out.println(res);
    }
}
