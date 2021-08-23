package io.github.vlad324.n653;

import java.util.LinkedList;

/**
 * {@link "https://leetcode.com/problems/two-sum-iv-input-is-a-bst/"}
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        final var nodes = new LinkedList<TreeNode>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            final var current = nodes.poll();
            if (current == null) {
                continue;
            }

            nodes.add(current.left);
            nodes.add(current.right);

            final var result = find(root, k - current.val);
            if (result != null && result != current) {
                return true;
            }
        }

        return false;
    }

    private TreeNode find(TreeNode root, int i) {
        if (root == null || root.val == i) {
            return root;
        }

        if (root.val > i) {
            return find(root.left, i);
        } else {
            return find(root.right, i);
        }
    }

    static class TreeNode {
        public final int val;
        public final TreeNode left;
        public final TreeNode right;

        public TreeNode(int val) {
            this(val, null, null);
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}