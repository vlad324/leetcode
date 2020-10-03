package io.github.vlad324.n129;

import java.util.Stack;

/**
 * {@link "https://leetcode.com/problems/sum-root-to-leaf-numbers/"}
 */
class Solution {
    public int sumNumbers2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        final var stack = new Stack<Pair>();
        stack.push(new Pair(root, 0));

        int sum = 0;
        while (!stack.isEmpty()) {
            final var current = stack.pop();
            final var newValue = current.value * 10 + current.node.val;

            if (current.node.left == null && current.node.right == null) {
                sum += newValue;
            }

            if (current.node.right != null) {
                stack.push(new Pair(current.node.right, newValue));
            }

            if (current.node.left != null) {
                stack.push(new Pair(current.node.left, newValue));
            }
        }

        return sum;
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return root.val;
        } else if (root.left == null) {
            return sum(root.right, root.val);
        } else if (root.right == null) {
            return sum(root.left, root.val);
        }

        return sum(root.left, root.val) + sum(root.right, root.val);
    }

    private int sum(TreeNode current, int previous) {
        if (current == null) {
            return 0;
        }

        final var value = previous * 10 + current.val;
        if (current.left == null && current.right == null) {
            return value;
        }

        return sum(current.left, value) + sum(current.right, value);
    }

    private static class Pair {
        public final TreeNode node;
        public final int value;

        private Pair(TreeNode node, int value) {
            this.node = node;
            this.value = value;
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