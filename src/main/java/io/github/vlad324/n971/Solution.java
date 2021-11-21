package io.github.vlad324.n971;

import io.github.vlad324.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/"}
 */
class Solution {

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        final var result = new ArrayList<Integer>();
        final var i = dfs(root, voyage, 0, result);
        if (i == -1) {
            return List.of(-1);
        }

        return result;
    }

    private int dfs(TreeNode root, int[] voyage, int i, ArrayList<Integer> result) {
        if (root == null) {
            return i;
        }

        if (i == -1 || root.val != voyage[i]) {
            return -1;
        }

        if (root.left != null && root.left.val != voyage[i + 1]) {
            result.add(root.val);
            i = dfs(root.right, voyage, i + 1, result);
            return dfs(root.left, voyage, i, result);
        } else {
            i = dfs(root.left, voyage, i + 1, result);
            return dfs(root.right, voyage, i, result);
        }
    }
}
