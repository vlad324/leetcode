package io.github.vlad324.n95;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * {@link "https://leetcode.com/problems/unique-binary-search-trees-ii/"}
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    public List<TreeNode> generate(int l, int r) {
        final var result = new LinkedList<TreeNode>();
        if (l == r) {
            result.add(new TreeNode(l));
        } else if (l > r) {
            result.add(null);
        } else {
            for (int i = l; i < r + 1; i++) {
                final var lefts = generate(l, i - 1);
                final var rights = generate(i + 1, r);

                for (final var lt : lefts) {
                    for (final var rt : rights) {
                        result.add(new TreeNode(i, lt, rt));
                    }
                }
            }
        }

        return result;
    }

    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this(val, null, null);
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

        @Override
        public String toString() {
            return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
        }
    }
}
