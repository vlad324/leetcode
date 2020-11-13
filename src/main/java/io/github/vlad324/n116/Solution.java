package io.github.vlad324.n116;

import java.util.LinkedList;
import java.util.Objects;

/**
 * {@link "https://leetcode.com/problems/populating-next-right-pointers-in-each-node/"}
 */
class Solution {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        final var queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            final int s = queue.size();

            Node previous = null;
            for (int i = 0; i < s; i++) {
                final var current = queue.poll();

                if (current.left != null) {
                    queue.add(current.right);
                    queue.add(current.left);
                }

                current.next = previous;
                previous = current;
            }
        }

        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node(int val) {
            this(val, null, null);
        }

        public Node(int val, Node next) {
            this(val, null, null, next);
        }

        public Node(int val, Node left, Node right) {
            this(val, left, right, null);
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final Node node = (Node) o;
            return val == node.val &&
                Objects.equals(left, node.left) &&
                Objects.equals(right, node.right) &&
                Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right, next);
        }
    }
}
