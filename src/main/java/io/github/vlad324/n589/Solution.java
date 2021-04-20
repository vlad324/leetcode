package io.github.vlad324.n589;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/n-ary-tree-preorder-traversal/"}
 */
class Solution {
    public List<Integer> preorder(Node root) {
        final var result = new ArrayList<Integer>();
        preorder(root, result);
        return result;
    }

    private void preorder(Node root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);

        if (root.children == null) {
            return;
        }

        for (final var n : root.children) {
            preorder(n, result);
        }
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node(int val) {
            this(val, null);
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }
}
