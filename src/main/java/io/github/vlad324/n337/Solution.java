package io.github.vlad324.n337;

import io.github.vlad324.common.TreeNode;

/**
 * {@link "https://leetcode.com/problems/house-robber-iii/"}
 */
class Solution {

    private static final int ROB_INDEX = 0;
    private static final int NOT_ROB_INDEX = 1;

    public int rob(TreeNode root) {
        int[] answer = helper(root);
        return Math.max(answer[ROB_INDEX], answer[NOT_ROB_INDEX]);
    }

    private int[] helper(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = helper(node.left);
        int[] right = helper(node.right);

        // if we rob this node, we cannot rob its children
        int rob = node.val + left[NOT_ROB_INDEX] + right[NOT_ROB_INDEX];
        // else, we free to choose rob its children or not
        int notRob = Math.max(left[ROB_INDEX], left[NOT_ROB_INDEX]) + Math.max(right[ROB_INDEX], right[NOT_ROB_INDEX]);

        return new int[]{rob, notRob};
    }
}
