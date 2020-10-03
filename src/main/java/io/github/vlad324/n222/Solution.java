package io.github.vlad324.n222;

/**
 * {@link "https://leetcode.com/problems/count-complete-tree-nodes/"}
 */
class Solution {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        final var h = height(root);
        final var rh = height(root.right);

        return rh == h - 1 ?
            (1 << (h - 1)) + countNodes(root.right) :
            (1 << (h - 2)) + countNodes(root.left);
    }

    private int height(TreeNode current) {
        return current == null ? 0 : 1 + height(current.left);
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
