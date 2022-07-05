package com.wang;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution5 {
    public static String removeChar(String s, int k){
        PriorityQueue<int[]>queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0]? o1[1] - o2[1]:o1[0] - o2[0];
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            int[]temp = new int[2];
            temp[0] = s.charAt(i);
            temp[1] = i;
            queue.offer(temp);
        }
        Set<Integer> set = new HashSet<>();
        while(k > 0){
            int[]temp = queue.poll();
            set.add(temp[1]);
            k--;
        }
        for(int i = 0; i < s.length(); i++){
            if(!set.contains(i))
                sb.append(s.charAt(i));

        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String s = "abcdbb";
        int k = 2;
        String res = removeChar(s,k);
        System.out.println(res);

    }
}
