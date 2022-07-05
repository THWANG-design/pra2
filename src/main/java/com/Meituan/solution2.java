package com.Meituan;

public class solution2 {

    public static int findMaxSum(int[]array){

        //建立一个包含当前数值的最大子序列和;
        int n = array.length;
        int sum = 0;
        int[]containsDp = new int[n];

        for(int i = 0; i < n; i++){
            if(sum <= 0)
                sum = 0;
            containsDp[i] = array[i] + sum;
            sum += array[i];
        }
        //建立一个到目前index中，最大子序列是多少;
        int[]useDp = new int[n];
        useDp[0] = containsDp[0];
        for(int i = 1; i < n ;i++){
            //对于每一个index来说，可以包含自己，也可以不包含自己;
            useDp[i] = Math.max(useDp[i-1], containsDp[i]);
        }
        //反转的话就是我们可以使用前一个的最大子序列和；
        int res = array[0];
        int[]reverseDp = new int[n];
        for(int i = 1; i < n; i++){
            reverseDp[i] = Math.max(array[i], array[i] + useDp[i-1]);
            reverseDp[i] = Math.max(reverseDp[i], array[i] + reverseDp[i-1]);
            res = Math.max(res, reverseDp[i]);


        }

        return res;


    }

    public static void main(String[] args) {
        int[]array = new int[]{-1,3,-5,2,-1,3};
        int res = findMaxSum(array);
        System.out.println(res);
    }
}
