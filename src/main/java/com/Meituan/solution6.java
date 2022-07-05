package com.Meituan;

public class solution6 {

    public static int findmaxSubArraySize(int[]array){
        //寻找数组中乘积为正的子序列，在子序列中，1的个数大于等于-1;
        //和 》= 0;
        int res = 0;
        for(int i = 0; i < array.length; i++){
            int sum = 0;
            if(array[i] == -1)
                sum++;
            for(int j = i +1; j < array.length; j++){
                if(array[j] == -1)
                    sum++;
                if(sum % 2 == 0)
                    res++;
            }
        }

        return res;


    }

    public static void main(String[] args) {
        int[]array = new int[]{1,1,-1,-1};
        int res = findmaxSubArraySize(array);
        System.out.println(res);
    }

}
