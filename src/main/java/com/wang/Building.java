package com.wang;

import java.util.Stack;

public class Building {

    public static int[] findBuilding(int[]build){
        Stack<Integer>stack = new Stack<>();
        int[]res = new int[build.length];

        for(int i = 0; i < build.length; i++){
            res[i] = stack.size() + 1;
            if(stack.isEmpty() || stack.peek() > build[i]){
                stack.push(build[i]);
            }else{
                while(!stack.isEmpty() && stack.peek() <= build[i]){
                    stack.pop();
                }
                stack.push(build[i]);
            }

        }
        stack = new Stack<>();
        for(int i = build.length-1; i >= 0 ; i--){
            res[i] += stack.size();
            if(stack.isEmpty() || stack.peek() > build[i]){
                stack.push(build[i]);
            }else{
                while(!stack.isEmpty() && stack.peek() <= build[i]){
                    stack.pop();
                }
                stack.push(build[i]);
            }

        }
        return res;


    }

    public static void main(String[] args) {
        int[]res = findBuilding(new int[]{5,3,8,3,2,5});
        for (int n : res){
            System.out.println(n);
        }
    }
}
