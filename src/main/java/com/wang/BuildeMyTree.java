package com.wang;

import com.sun.source.tree.Tree;

import java.util.*;

public class BuildeMyTree {


    public TreeNode buildeMyTree(String[] s) {
        int index = 1;
        int n = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        int headVal = Integer.parseInt(s[0]);
        TreeNode head = new TreeNode(headVal);

        queue.offer(head);

        while (!queue.isEmpty() && index < s.length) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();

                if (s[index].equals("null")) {
                    temp.left = null;
                } else {
                    int leftVal = Integer.parseInt(s[index]);
                    TreeNode left = new TreeNode(leftVal);
                    temp.left = left;
                    queue.offer(left);
                }

                index++;
                if (s[index].equals("null")) {
                    temp.right = null;
                } else {
                    int rightVal = Integer.parseInt(s[index]);
                    TreeNode right = new TreeNode(rightVal);
                    temp.right = right;
                    queue.offer(right);
                }
                index++;
            }
        }

        return head;


    }

    public void bfs(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        List<Integer> list = new ArrayList<>();

        while (root != null || !stack.isEmpty()) {
            while(root != null) {

                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (root.right == null || root.right == prev) {
                list.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " , ");
        }


    }


    public String deCode(TreeNode root){
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode>queue = new LinkedList<>();
        TreeNode dummy = new TreeNode(-1);
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){

                TreeNode temp = queue.poll();
                if(temp == dummy){
                    sb.append("null,");
                    continue;
                }
                sb.append(temp.val + ",");
                if(temp.left == null && temp.right == null)
                        continue;
                if(temp.left == null){
                    queue.offer(dummy);
                }
                else{
                    queue.offer(temp.left);
                }
                if(temp.right == null){
                    queue.offer(dummy);

                }else {
                    queue.offer(temp.right);
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        BuildeMyTree buildeMyTree = new BuildeMyTree();
        String[]s = new String[]{"1", "2", "8", "null", "3", "10", "null", "6", "7", "11","13"};
        TreeNode head = buildeMyTree.buildeMyTree(s);
        buildeMyTree.bfs(head);
        System.out.println(buildeMyTree.deCode(head));
    }
}





class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }
}
