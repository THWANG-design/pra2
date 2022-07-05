package com;

public class tree {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    static int sum = 0;
    public static int findSum(TreeNode root){
        dfs(root, null);
        return sum;
    }

    public static void dfs(TreeNode root,TreeNode prev){
        if(root == null )
            return;

        if(root.left == null && root.right == null){
            if(prev != null && prev.right == null)
                sum += root.val;
            return;
        }

        dfs(root.left, root);
        dfs(root.right, root);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);

        head.right.right = new TreeNode(6);

        findSum(head);
        System.out.println(sum);
    }
}
