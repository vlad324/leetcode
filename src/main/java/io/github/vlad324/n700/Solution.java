package io.github.vlad324.n700;

import java.util.Objects;

/**
 * {@link "https://leetcode.com/problems/search-in-a-binary-search-tree/"}
 */
class Solution {

    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode next = root;
        while (next != null) {
            if (next.val == val) {
                return next;
            }

            next = next.val > val ? next.left : next.right;
        }

        return null;
    }

    static class TreeNode {
        public final int val;
        public final TreeNode left;
        public final TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
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
            return val == treeNode.val &&
                Objects.equals(left, treeNode.left) &&
                Objects.equals(right, treeNode.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }
    }
}
