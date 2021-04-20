package io.github.vlad324.n589;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/n-ary-tree-preorder-traversal/"}
 */
class Solution {

    public List<Integer> preorderSequential(Node root) {
        final var result = new ArrayList<Integer>();

        if (root == null) {
            return result;
        }

        final var stack = new ArrayDeque<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            final var node = stack.pop();
            result.add(node.val);

            if (node.children == null || node.children.isEmpty()) {
                continue;
            }

            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }

        return result;
    }

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
            this(val, Collections.emptyList());
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }
}
