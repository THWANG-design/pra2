package com;

import java.util.Random;

public class Rand {

    public static int rand5(){
       Random random = new Random();
       return random.nextInt(5) + 1;
    }

    public static int rand11(){
        int num = rand16();
        while(num > 11){
            num = rand16();
        }
        return num;
    }

    public static int rand8(){
        int num1 = rand5();
        while(num1 == 5){
            num1 = rand5();
        }
        int first = num1 % 2;

        int second = rand5();
        while(second == 5){
            second = rand5();
        }
        return first == 0? second : 4 + second;
    }

    public static int rand16(){
        int num1 = rand8();

        int first = num1 % 2;

        int second = rand8();
        return first == 0? second : 8 + second;
    }

    public static void main(String[] args) {
        int time = 0;
        int k = 10000;
        while(k > 0){
            int temp = rand11();
            if(temp == 7)
                    time++;
            k--;
        }
        System.out.println((double) time / 10000);
    }

}


