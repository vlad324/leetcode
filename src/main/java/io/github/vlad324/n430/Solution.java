package io.github.vlad324.n430;

import java.util.Objects;

/**
 * {@link "https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/"}
 */
class Solution {

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        var node = head;
        while (node != null) {
            if (node.child != null) {
                final var next = node.next;
                var sublistHead = flatten(node.child);

                // relink current
                node.next = sublistHead;
                sublistHead.prev = node;
                node.child = null;

                // relink last with next
                if (next != null) {
                    // find last of sublist
                    while (sublistHead.next != null) {
                        sublistHead = sublistHead.next;
                    }

                    sublistHead.next = next;
                    next.prev = sublistHead;
                }

                node = next;
                continue;
            }

            node = node.next;
        }

        return head;
    }

    static class Node {
        int val;
        Node prev;
        Node next;
        Node child;

        public Node(int val) {
            this(val, null, null, null);
        }

        public Node(int val, Node prev, Node next, Node child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final Node node = (Node) o;
            return val == node.val &&
                Objects.equals(next, node.next) &&
                Objects.equals(child, node.child);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next, child);
        }
    }
}
