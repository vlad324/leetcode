package io.github.vlad324.n111;

import java.util.LinkedList;

/**
 * {@link "https://leetcode.com/problems/minimum-depth-of-binary-tree/"}
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        final var queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        int level = 1;

        while (true) {
            final var current = queue.poll();

            if (current == null) {
                if (queue.isEmpty()) {
                    return level;
                }

                level++;
                queue.add(null);
                continue;
            }

            if (current.left == null && current.right == null) {
                return level;
            }

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
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
