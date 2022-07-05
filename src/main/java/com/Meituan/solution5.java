package com.Meituan;

import java.util.Timer;

public class solution5 {
    public static boolean isLuckyNum(int n){
        if(n % 11 != 0)
            return false;

        int num = 0;

        while(n != 0){
            int temp = n % 10;
            if(temp == 1)
                num++;
            if(num >= 2)
                return true;
            n = n /10;
        }

        return false;
    }

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        boolean temp = isLuckyNum(11);
        System.out.println(temp);
        int ini = 1000000000;
        for(int i = 0; i < 500; i++){
            boolean luckyNum = isLuckyNum(i);
            ini ++;
        }
        long end = System.currentTimeMillis();

        System.out.println(end - time);

    }

}
