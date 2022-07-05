package jvm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public long[] getDistances(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            list = map.getOrDefault(temp, new ArrayList<Integer>());
            list.add(i);
            map.put(temp, list);
        }

        long[]result = new long[arr.length];
        for(int i = 0; i < arr.length; i++){
            long ans = 0;
            list = map.get(arr[i]);
            for(int j = 0; j < list.size(); j++){
                int end = list.size() - 1;
                if( j == 0) {
                    for (int n = 1; n < list.size(); n++) {
                        ans += Math.abs(i - list.get(n));
                    }
                    result[i] = ans;
                }
                else{
                    result[list.get(j)] = result[list.get(j - 1)] - (2*j - end - 1) * (list.get(j) - list.get(j - 1));

                }


            }

        }
        return result;

    }
}
