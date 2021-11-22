package io.github.vlad324.n450;

import io.github.vlad324.common.TreeNode;

import java.util.LinkedList;

/**
 * {@link "https://leetcode.com/problems/delete-node-in-a-bst/"}
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        final var holder = new TreeNode(-1, root, null);
        final var queue = new LinkedList<TreeNode>();
        queue.add(holder);
        while (!queue.isEmpty()) {
            final var current = queue.poll();
            if (current == null) {
                continue;
            }

            if (current.left != null && current.left.val == key) {
                current.left = delete(current.left);
                break;
            }

            if (current.right != null && current.right.val == key) {
                current.right = delete(current.right);
                break;
            }

            queue.add(current.left);
            queue.add(current.right);
        }

        return holder.left;
    }

    private TreeNode delete(TreeNode root) {
        if (root.left == null && root.right == null) {
            return null;
        }

        if (root.left != null && root.right != null) {
            var prev = root;
            var node = root.right;
            while (node.left != null) {
                prev = node;
                node = node.left;
            }

            if (prev != root) {
                prev.left = node.right;
                node.right = root.right;
            }
            node.left = root.left;
            return node;
        }

        return root.left != null ? root.left : root.right;
    }
}
