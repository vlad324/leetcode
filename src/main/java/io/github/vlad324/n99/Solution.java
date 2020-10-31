package io.github.vlad324.n99;

import java.util.Objects;

/**
 * {@link "https://leetcode.com/problems/recover-binary-search-tree/"}
 */
class Solution {
    TreeNode firstElement;
    TreeNode secondElement;
    TreeNode prevElement;

    public void recoverTree(TreeNode root) {
        inOrder(root);

        int tmp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = tmp;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);

        if (firstElement == null && prevElement != null && prevElement.val > node.val) {
            firstElement = prevElement;
        }

        if (firstElement != null && prevElement.val > node.val) {
            secondElement = node;
        }

        prevElement = node;

        inOrder(node.right);
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