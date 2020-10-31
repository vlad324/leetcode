package io.github.vlad324.n99;

import java.util.Objects;

/**
 * {@link "https://leetcode.com/problems/recover-binary-search-tree/"}
 */
class Solution {
    public void recoverTree(TreeNode root) {
        while (true) {
            final var result = new Result();
            findInvalidNode(root, Long.MIN_VALUE, Long.MAX_VALUE, result);

            if (result.node1 == null) {
                return;
            }

            result.node2.val = result.node1.val;
            result.node1.val = (int) result.valueOfNode2;
        }
    }

    private void findInvalidNode(TreeNode node, long minValue, long maxValue, Result result) {
        if (node == null || result.node1 != null) {
            return;
        }

        if (node.val < minValue) {
            result.node1 = node;
            result.valueOfNode2 = minValue;
            return;
        }

        if (node.val > maxValue) {
            result.node1 = node;
            result.valueOfNode2 = maxValue;
            return;
        }

        findInvalidNode(node.left, minValue, node.val, result);
        findInvalidNode(node.right, node.val, maxValue, result);

        if (result.node1 != null && node.val == result.valueOfNode2) {
            result.node2 = node;
        }
    }

    static class Result {
        TreeNode node1;
        long valueOfNode2;
        TreeNode node2;
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
