package io.github.vlad324.n236;

import java.util.Objects;
import java.util.Stack;

/**
 * {@link "https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/"}
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        final var path1 = new Stack<TreeNode>();
        final var path2 = new Stack<TreeNode>();

        dfs(root, p, path1);
        dfs(root, q, path2);

        path1.pop();
        path2.pop();
        var result = root;
        while (!path1.isEmpty() && !path2.isEmpty() && path1.peek().val == path2.peek().val) {
            result = path1.pop();
            path2.pop();
        }

        return result;
    }

    private void dfs(TreeNode root, TreeNode node, Stack<TreeNode> path) {
        if (root == null) {
            return;
        }

        if (root.val == node.val) {
            path.push(root);
            return;
        }

        dfs(root.left, node, path);
        if (!path.isEmpty()) {
            path.push(root);
            return;
        }

        dfs(root.right, node, path);
        if (!path.isEmpty()) {
            path.push(root);
            return;
        }
    }

    static class TreeNode {
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val);
        }
    }
}
