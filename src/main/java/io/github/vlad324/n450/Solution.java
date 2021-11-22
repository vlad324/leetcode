package io.github.vlad324.n450;

import io.github.vlad324.common.TreeNode;

/**
 * {@link "https://leetcode.com/problems/delete-node-in-a-bst/"}
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            if (root.left != null && root.right != null) {
                var node = root.right;
                while (node.left != null) {
                    node = node.left;
                }

                root.right = deleteNode(root.right, node.val);
                root.val = node.val;

                return root;
            } else if (root.left != null) {
                return root.left;
            } else {
                return root.right;
            }
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }
}
