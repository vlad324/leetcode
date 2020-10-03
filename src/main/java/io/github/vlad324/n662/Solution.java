package io.github.vlad324.n662;

import java.util.LinkedList;

/**
 * {@link "https://leetcode.com/problems/maximum-width-of-binary-tree/"}
 */
class Solution {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        final var queue = new LinkedList<TreeNode>();
        root.val = 1;
        queue.offer(root);

        int maxWidth = 0;
        while (!queue.isEmpty()) {
            final var size = queue.size();

            final int firstIndex = queue.peek().val;

            TreeNode current = null;
            for (int i = 0; i < size; i++) {
                current = queue.poll();

                if (current.left != null) {
                    current.left.val = current.val * 2;
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    current.right.val = current.val * 2 + 1;
                    queue.offer(current.right);
                }
            }

            maxWidth = Math.max(maxWidth, current.val - firstIndex + 1);
        }

        return maxWidth;
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
    }
}
