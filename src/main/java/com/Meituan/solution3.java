package com.Meituan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class solution3 {

    public static List<Integer>findMaxVolumn(int[]size, char[]direction, int[]depth){
        int time = size[1];
        int inititalSize = size[0];
        List<Integer>x = new ArrayList<>();
        List<Integer>y = new ArrayList<>();
        List<Integer>z = new ArrayList<>();
        x.add(0); x.add(inititalSize);
        y.add(0); y.add(inititalSize);
        z.add(0); z.add(inititalSize);
        List<Integer>res = new ArrayList<>();
        int curX = inititalSize;
        int curY = inititalSize;
        int curZ = inititalSize;
        for(int i = 0; i < time; i++){
            char c = direction[i];
            if(c == 'x'){
                x.add(depth[i]);
                curX = findMax(x);
            }
            else if(c == 'y'){
                y.add(depth[i]);
                curY = findMax(y);
            }
            else if(c == 'z'){
                z.add(depth[i]);
                curZ = findMax(z);
            }
            int tempRes = curX * curY * curZ;
            res.add(tempRes);

        }
        return res;

    }

    public static int findMax(List<Integer>list){
        int res = 0;
        Collections.sort(list);

        for(int i = 1; i < list.size(); i++){
            res = Math.max(res, list.get(i) - list.get(i-1));
        }
        return res;
    }

    public static void main(String[] args) {
        int[]size = new int[]{2,3};
        char[]direction = new char[]{'x','y','z'};
        int[]depth = new int[]{1,1,1};

        List<Integer>list = findMaxVolumn(size,direction,depth);

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
