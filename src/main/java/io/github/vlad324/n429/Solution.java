package io.github.vlad324.n429;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/n-ary-tree-level-order-traversal/"}
 */
class Solution {

    public static final Node SEPARATOR = null;

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }

        final var result = new LinkedList<List<Integer>>();

        final var queue = new LinkedList<Node>();
        queue.add(root);
        queue.add(SEPARATOR);

        while (true) {
            final var currentLevel = new LinkedList<Integer>();

            Node current;
            while ((current = queue.poll()) != SEPARATOR) {
                currentLevel.add(current.val);

                if (current.children != null && !current.children.isEmpty()) {
                    queue.addAll(current.children);
                }
            }

            result.add(currentLevel);

            if (queue.isEmpty()) {
                break;
            }

            queue.offer(SEPARATOR);
        }

        return result;
    }

    public static class Node {
        public final int val;
        public final List<Node> children;

        public Node(int val) {
            this.val = val;
            this.children = null;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }
}
