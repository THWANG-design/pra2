package jvm;

import java.util.*;

public class QuickSort {
    static boolean res = false;
    public static int minimumNumbers(int num, int k) {
        if(num == 0)
            return 0;


        List<Integer>list = new ArrayList<>();
        int time = 1;
        if(k == 0){
            if(num % 10 != 0)
                return -1;
            else{
                return 1;
            }
        }
        int cur = k;
        boolean isOk = true;
        for(int i = 1; i <= 10; i++){
            time = i;
            cur = k * i;
            if(num % 10 == cur % 10){
                break;
            }
            if(time == 10)
                isOk =false;
        }

        if(!isOk)
            return -1;



        while(k <= num){
            list.add(k);
            k += 10;
        }
        if(list.contains(num))
            return 1;
        Collections.reverse(list);
        dfs(list, num, time, 0, 0);
        if(res)
            return time;
        return -1;




    }

    public static void dfs(List<Integer> list, int num, int time, int sum, int curTime){
        if(sum > num)
            return;
        if(curTime == time){
            if(sum == num){
                res = true;
                return;
            }
        }
        for(int i = 0; i < list.size() && !res; i++){
            dfs(list,num,time, sum + list.get(i), curTime + 1);

        }
    }


        public static void main(String[] args) {
            int res = minimumNumbers(197, 2);
            System.out.println(res);

    }
}
