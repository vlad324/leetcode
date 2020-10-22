package io.github.vlad324.n701;

import java.util.Objects;

/**
 * {@link "https://leetcode.com/problems/insert-into-a-binary-search-tree/"}
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        var node = root;
        while (true) {
            if (node.val > val) {
                if (node.left != null) {
                    node = node.left;
                } else {
                    node.left = new TreeNode(val);
                    break;
                }
            } else {
                if (node.right != null) {
                    node = node.right;
                } else {
                    node.right = new TreeNode(val);
                    break;
                }
            }
        }

        return root;
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
