package io.github.vlad324.n103;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/"}
 */
class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        final var result = new LinkedList<List<Integer>>();

        final var queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            final var s = queue.size();

            final var level = new LinkedList<Integer>();
            final boolean reverse = result.size() % 2 != 0;
            for (int i = 0; i < s; i++) {
                final var current = queue.poll();

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }

                if (reverse) {
                    level.addFirst(current.val);
                } else {
                    level.add(current.val);
                }
            }
            result.add(level);
        }

        return result;
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
