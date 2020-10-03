package io.github.vlad324.n437;

import java.util.HashMap;

/**
 * {@link "https://leetcode.com/problems/path-sum-iii/"}
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        final var counts = new HashMap<Integer, Integer>();
        counts.put(sum, 1);
        return dfs(root, sum, 0, counts);
    }

    private int dfs(TreeNode root, int sum, int rootSum, HashMap<Integer, Integer> counts) {
        if (root == null) {
            return 0;
        }

        rootSum += root.val;
        var result = counts.getOrDefault(rootSum, 0);

        counts.compute(rootSum + sum, (k, v) -> v == null ? 1 : v + 1);
        result += dfs(root.left, sum, rootSum, counts);
        result += dfs(root.right, sum, rootSum, counts);
        counts.compute(rootSum + sum, (k, v) -> v - 1);

        return result;
    }

    static class TreeNode {
        public final int val;
        public final TreeNode left;
        public final TreeNode right;

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