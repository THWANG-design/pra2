package com.wang;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BuilderMyTree2 {
    int index;
    public String enCode(TreeNode root){
        StringBuilder sb = new StringBuilder();
        enCodeDfs(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public TreeNode deCode(String s){
        String[]array = s.split("\\,");
        return dfs(array);
    }

    public TreeNode dfs(String[]array){
        if(array[index].equals("null"))
            return null;

        TreeNode head = new TreeNode(Integer.parseInt(array[index]));
        index++;
        head.left = dfs(array);
        index++;
        head.right = dfs(array);
        return head;
    }

    public void enCodeDfs(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return;
        }
        sb.append(root.val + ",");
        enCodeDfs(root.left, sb);
        enCodeDfs(root.right,sb);

    }

    public void bfs(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode>stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ",");
        }
    }

    public static void main(String[] args) {
        BuilderMyTree2 builderMyTree = new BuilderMyTree2();
        String s = "1,2,null,3,6,null,null,7,null,null,8,10,11,null,null,13,null,null,null";
        TreeNode root = builderMyTree.deCode(s);
        String rs = builderMyTree.enCode(root);
        System.out.println(rs);
        System.out.println();
        builderMyTree.bfs(root);

    }


}




