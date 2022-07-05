package jvm;

import java.util.*;

public class word {

    static class Node{
        boolean isEnd;
        Node[]array;

        public Node(){
            array = new Node[26];
        }
    }

    static Node node = new Node();


    public static void addWord(String word) {
        add(word);
    }

    public static boolean search(String word) {
        return search(word, 0, node);
    }


    public static void add(String word){
        Node temp = node;

        for(int i = 0; i < word.length(); i++){
            char cha = word.charAt(i);
            int index = cha - 'a';
            if(temp.array[index] == null){
                Node temp1 = new Node();
                temp.array[index] = temp1;
            }

            temp = temp.array[index];
        }
        temp.isEnd = true;
    }

    public static boolean search(String word, int index, Node node){
        if(node == null)
            return false;
        if(index == word.length()){
            return node.isEnd;
        }
        char cur = word.charAt(index);
        int index1 = cur - 'a';

        if(cur == '.'){
            boolean res = false;
            for(int i = 0; i < 26; i++){
                if(node.array[i] != null){
                    res |= search(word, index + 1, node.array[i]);
                }
            }
            return res;
        }
        else{
            if(node.array[index1] == null)
                return false;
            else
                return search(word, index + 1, node.array[index1]);
        }


    }

    public static void main(String[] args) {
        addWord("bad");
        boolean res = search(".ad");
        System.out.println(res);


    }


    }





