package io.github.vlad324.n449;

import java.util.LinkedList;
import java.util.Objects;

/**
 * {@link "https://leetcode.com/problems/serialize-and-deserialize-bst/"}
 */
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        final var queue = new LinkedList<TreeNode>();
        queue.push(root);

        final var result = new StringBuilder();
        while (!queue.isEmpty()) {
            final var current = queue.poll();

            if (current == null) {
                result.append("null").append(" ");
                continue;
            }

            result.append(current.val).append(" ");

            queue.add(current.left);
            queue.add(current.right);
        }

        return result.deleteCharAt(result.length() - 1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        final var values = data.split(" ");

        if ("null".equals(values[0])) {
            return null;
        }

        final var root = new TreeNode(Integer.parseInt(values[0]));

        final var queue = new LinkedList<TreeNode>();
        queue.push(root);

        int i = 1;
        while (!queue.isEmpty()) {
            final var current = queue.poll();

            if (i == values.length) {
                break;
            }

            if (!"null".equals(values[i])) {
                current.left = new TreeNode(Integer.parseInt(values[i]));
                queue.add(current.left);
            }
            i++;


            if (i == values.length) {
                break;
            }

            if (!"null".equals(values[i])) {
                current.right = new TreeNode(Integer.parseInt(values[i]));
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this(x, null, null);
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
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
