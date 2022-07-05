package com.Meituan;

import java.util.Scanner;

public class Solution4 {
    static class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
        }
    }

    public static Node reverseNode(Node node){
        Node prev = null;

        while(node != null){
            Node temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(4);
        head.next.next = new Node(6);

        Node res = reverseNode(head);

        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }



    }

}
