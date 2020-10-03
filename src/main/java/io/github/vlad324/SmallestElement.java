package io.github.vlad324;

import java.util.Stack;

/**
 * {@link "https://leetcode.com/problems/kth-smallest-element-in-a-bst/"}
 */
public class SmallestElement {
    public int kthSmallest(TreeNode root, int k) {
        final var stack = new Stack<TreeNode>();

        int visited = 0;
        var current = root;
        while (true) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            if (++visited == k) {
                return current.val;
            }

            current = current.right;
        }
    }

    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
