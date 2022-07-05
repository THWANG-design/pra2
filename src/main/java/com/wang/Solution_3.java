package com.wang;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Solution_3 {
    static Deque<Integer> normalStack;
    static Deque<Integer> stack;

    public Solution_3(){
        normalStack = new LinkedList<Integer>();
        stack = new LinkedList<Integer>();

    }

    public static void appendTail(int num){
        normalStack.push(num);

    }

    public static int deleteHead(){
        if(normalStack.isEmpty()){
            if(stack.isEmpty())
                    return -1;
            return stack.pop();
        }
        else {
            while(!normalStack.isEmpty()){
                stack.push(normalStack.pop());
            }
            return stack.pop();
        }
    }

    public static void main(String[] args) {
        new Solution_3();
        System.out.println(deleteHead());
        appendTail(5);
        appendTail(2);

        System.out.println(deleteHead());
        System.out.println(deleteHead());


    }
}
