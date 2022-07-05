package com.sort;

class Solution {
    long res = Long.MAX_VALUE;
    public long GetMinCalculateCount(long sourceX, long sourceY, long targetX, long targetY) {
        // write code here
        dfs(sourceX, sourceY, targetX, targetY, 0);
        return res;
    }

    public void dfs(long x, long y, long tarX, long tarY, int time){
        if(x > tarX || y > tarY)
            return;
        if(x == tarX || y == tarY){
            if(x == tarX && y == tarY){
                res = Math.min(res, time);
            }
            return;
        }

        dfs(x + 1, y + 1, tarX, tarY,time + 1);
        dfs(x * 2, y * 2, tarX, tarY, time + 1);

    }

    public static void main(String[] args) {
        Solution b = new Solution();

        long res = b.GetMinCalculateCount(10,100,22,202);
        System.out.println(res);
    }

}
