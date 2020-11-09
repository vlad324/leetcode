package io.github.vlad324.n1026;

/**
 * {@link "https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/"}
 */
class Solution {
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode node, int max, int min) {
        if (node == null) {
            return max - min;
        }

        max = Math.max(max, node.val);
        min = Math.min(min, node.val);

        return Math.max(dfs(node.left, max, min), dfs(node.right, max, min));
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
