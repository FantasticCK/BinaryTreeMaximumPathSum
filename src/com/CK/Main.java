package com.CK;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(8);
//        TreeNode node6 = new TreeNode(4);
//        TreeNode node6 = new TreeNode(4);
        TreeNode node9 = new TreeNode(7);
        TreeNode node10 = new TreeNode(4);
//        TreeNode node6 = new TreeNode(4);
//        TreeNode node6 = new TreeNode(4);
//        TreeNode node13 = new TreeNode(9);
//        TreeNode node14 = new TreeNode(8);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node4.left = node9;
        node4.right = node10;
//        node6.left = node13;
//        node6.right = node14;

        Solution solution = new Solution();
        System.out.println(solution.maxPathSum(root));
    }
}

class Solution {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    public int helper(TreeNode root) {
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        //连接父节点的最大路径是一、二、四这三种情况的最大值
        int currSum = Math.max(Math.max(left + root.val, right + root.val), root.val);
        //当前节点的最大路径是一、二、三、四这四种情况的最大值
        int currMax = Math.max(currSum, left + right + root.val);
        //用当前最大来更新全局最大
        max = Math.max(currMax, max);
        return currSum;
    }
}