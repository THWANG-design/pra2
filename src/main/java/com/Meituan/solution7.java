package com.Meituan;

import java.util.*;

public class solution7 {
    public static int findMaxCustomer(int n, int m, List<int[]> list ){
        PriorityQueue<int[]>queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        Map<Integer,ArrayList<Integer>>map = new HashMap<>();
        int[]a = new int[m + 1];
        for(int[]temp :list){
            a[temp[0]]++;
            a[temp[1]]++;
            ArrayList<Integer>tempList = map.getOrDefault(temp[0], new ArrayList<>());
            if(!tempList.contains(temp[1]))
                tempList.add(temp[1]);
            map.put(temp[0], tempList);
            ArrayList<Integer>tempList1 = map.getOrDefault(temp[1], new ArrayList<>());
            if(!tempList1.contains(temp[0]))
                tempList1.add(temp[0]);
            map.put(temp[1], tempList1);

        }
        for(int i = 0; i <= m; i++){
            if(a[i] != 0){
                int[]t = new int[2];
                t[0] = i;
                t[1] = a[i];
                queue.offer(t);
            }
        }

        int res = 0;
        Set<Integer>set = new HashSet<>();
        while(!queue.isEmpty()){
            int[]temp = queue.poll();
            if(set.contains(temp[0]))
                continue;
            set.add(temp[0]);
            ArrayList<Integer>tempList = map.get(temp[0]);
            int t = tempList.get(0);
            boolean isChanged = true;
            for(int i = 0; i < tempList.size(); i++){
                if(a[tempList.get(i)] <= a[t] && !set.contains(tempList.get(i))) {
                    t = tempList.get(i);
                    isChanged = false;
                }
            }
            if(isChanged) {
                set.remove(temp[0]);
                continue;
            }
            set.add(t);
            res++;
        }
        return res;


    }

    public static void main(String[] args) {
        int n = 3;
        int m = 9;
        List<int[]>list = new ArrayList<>();
        int[]a = new int[]{1,2};
        int[]b = new int[]{1,3};
        int[]c = new int[]{1,4};
        int[]d = new int[]{5,4};
        int[]p = new int[]{2,7};
        int[]k = new int[]{5,6};
        int[]q = new int[]{8,9};
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(q);
        list.add(k);
        list.add(p);
        int res = findMaxCustomer(n,m,list);
        System.out.println(res);
    }
}
