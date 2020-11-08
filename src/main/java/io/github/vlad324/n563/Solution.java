package io.github.vlad324.n563;

/**
 * {@link "https://leetcode.com/problems/binary-tree-tilt/"}
 */
class Solution {
    public int findTilt(TreeNode root) {
        int[] result = new int[1];
        dfs(root, result);
        return result[0];
    }

    private int dfs(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }

        int leftSum = dfs(root.left, result);
        int rightSum = dfs(root.right, result);

        result[0] += Math.abs(leftSum - rightSum);

        return leftSum + rightSum + root.val;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this(val, null, null);
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
