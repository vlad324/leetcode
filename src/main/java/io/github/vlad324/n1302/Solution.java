package io.github.vlad324.n1302;

import io.github.vlad324.common.TreeNode;

/**
 * {@link "https://leetcode.com/problems/deepest-leaves-sum/"}
 */
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        final var levelAndSum = new int[]{0, 0};
        dfs(root, 0, levelAndSum);
        return levelAndSum[1];
    }

    private void dfs(TreeNode root, int level, int[] levelAndSum) {
        if (root == null) {
            return;
        }

        level++;
        if (level == levelAndSum[0]) {
            levelAndSum[1] += root.val;
        } else if (level > levelAndSum[0]) {
            levelAndSum[0] = level;
            levelAndSum[1] = root.val;
        }

        dfs(root.left, level, levelAndSum);
        dfs(root.right, level, levelAndSum);
    }
}
