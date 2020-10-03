package io.github.vlad324.n107;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/binary-tree-level-order-traversal-ii/"}
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        final var result = new LinkedList<List<Integer>>();

        final var queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);

        var level = new LinkedList<Integer>();
        while (true) {
            final var current = queue.poll();

            if (current == null) {
                result.addFirst(level);

                if (queue.isEmpty()) {
                    return result;
                }

                level = new LinkedList<>();
                queue.add(null);
            } else {
                level.add(current.val);

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
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