package io.github.vlad324.n1008;

import java.util.Objects;
import java.util.Stack;

/**
 * {@link "https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/"}
 */
class Solution {

    public TreeNode bstFromPreorder(int[] preorder) {
        final var root = new TreeNode(preorder[0]);

        final var stack = new Stack<TreeNode>();
        stack.push(root);

        int i = 1;
        while (!stack.empty() && i < preorder.length) {
            final var node = stack.pop();

            final var currentValue = preorder[i];
            final var newNode = new TreeNode(currentValue);
            if (currentValue < node.val && node.left == null) {
                node.left = newNode;
                stack.push(node);
                stack.push(newNode);
            } else if (currentValue > node.val) {
                if (!stack.empty() && currentValue > stack.peek().val) {
                    continue;
                } else {
                    node.right = newNode;
                    stack.push(newNode);
                }
            }
            i++;
        }


        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
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
