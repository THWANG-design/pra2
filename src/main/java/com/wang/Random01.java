package com.wang;

import java.util.Random;

public class Random01 {
    public static int random(int p){
        Random random = new Random();
        int res = random.nextInt(10);

        if(res < p)
            return 0;
        return 1;
    }


    public static int myRandom(int p){

        int size0 = p;
        int size1 = 10 - p;

        while(true){
            int temp = random(p);
            if(temp == 0)
                size0--;
            if(temp == 1)
                size1--;

            if(size0 == 0)
                return 0;
            if(size1 == 0)
                return 1;
        }
    }

    public static void main(String[] args) {
        int time1 = 0;
        for(int i = 0; i < 10; i++){
            int temp = myRandom(7);
            if(temp == 1)
                time1++;
        }
        System.out.println(time1);
    }

}
