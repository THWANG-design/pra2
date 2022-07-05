package com.Meituan;

class Solution {
    public class Trie{
        char val;
        Trie[]array;

        public Trie(char val){
            this.val = val;
            this.array = new Trie[10];
        }
    }
    Trie head;
    int res;
    int time;
    public void insert(int val){
        String s = val +"";
        Trie cur = head;
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if(cur.array[temp -'0'] == null){
                Trie t = new Trie(temp);
                cur.array[temp - '0'] = t;
            }
            cur = cur.array[temp -'0'];
        }
    }
    public int findKthNumber(int n, int k) {
        head = new Trie('0');
        for(int i = 1; i <= n; i++){
            insert(i);
        }
        Trie cur = head;
        time = k + 1;
        StringBuilder sb = new StringBuilder();
        dfs(head, sb);
        return res;
    }

    public void dfs(Trie cur, StringBuilder sb){
        if(cur == null){

            return;
        }
        time--;
        sb.append(cur.val);
        if(time == 0){
            res = Integer.parseInt(sb.toString());
            return;
        }
        for(int i = 0; i < 10; i++){
            dfs(cur.array[i], sb);
        }
        sb.deleteCharAt(sb.length() - 1);

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findKthNumber(4289384,1922239));
    }
}