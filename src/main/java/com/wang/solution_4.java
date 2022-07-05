package com.wang;

public class solution_4 {
    char[]loop = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    char[]num;
    StringBuffer sb;
    int n;
    int start;
    int nine;
    public String[] integerList(int n){
        num = new char[n];
        sb = new StringBuffer();
        this.n = n;
        start = n - 1;
        nine = 0;
        dfs(0);
        sb.deleteCharAt(sb.length() - 1);
        String[]res = sb.toString().split(",");
        return res;
    }

    public void dfs(int x){
        if(x == n){
            String temp = String.valueOf(num).substring(start);
            if(!temp.equals("0"))
                sb.append(temp + ",");
            if(nine + start == n)
                start--;
            return;
        }

        for(char c:loop){
            if(c == '9')
                nine++;
            num[x] = c;
            dfs(x + 1);
        }
        nine--;
    }

    public static void main(String[] args) {
        solution_4 s = new solution_4();
        String[] strings = s.integerList(8);
        for(String s1 : strings)
            System.out.println(s1);

    }
}
