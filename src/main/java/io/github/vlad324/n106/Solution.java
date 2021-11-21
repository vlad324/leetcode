package io.github.vlad324.n106;

import io.github.vlad324.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link "https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/"}
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        final var valueToIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            valueToIndex.put(inorder[i], i);
        }
        return helper(valueToIndex, 0, inorder.length, postorder, postorder.length - 1);
    }

    private TreeNode helper(Map<Integer, Integer> valueToIndex, int start, int end, int[] postorder, int i) {
        if (start == end) {
            return null;
        }

        int splitIndex = valueToIndex.get(postorder[i]);
        while (i > 0 && (splitIndex < start || splitIndex >= end)) {
            i--;
            splitIndex = valueToIndex.get(postorder[i]);
        }

        return new TreeNode(postorder[i],
            helper(valueToIndex, start, splitIndex, postorder, i),
            helper(valueToIndex, splitIndex + 1, end, postorder, i));
    }
}
