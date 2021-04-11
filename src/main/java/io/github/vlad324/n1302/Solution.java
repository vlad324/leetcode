package io.github.vlad324.n1302;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@link "https://leetcode.com/problems/deepest-leaves-sum/"}
 */
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        final var cache = new HashMap<Integer, List<Integer>>();
        final int maxLevel = dfs(root, cache, 0);
        return cache.get(maxLevel).stream().reduce(0, Integer::sum);
    }

    private int dfs(TreeNode root, Map<Integer, List<Integer>> cache, int level) {
        if (root == null) {
            return level;
        }

        level++;
        if (root.left == null && root.right == null) {
            cache.computeIfAbsent(level, k -> new ArrayList<>())
                .add(root.val);
            return level;
        }

        return Math.max(dfs(root.left, cache, level), dfs(root.right, cache, level));
    }

    public static class TreeNode {
        private final int val;
        private final TreeNode left;
        private final TreeNode right;

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
