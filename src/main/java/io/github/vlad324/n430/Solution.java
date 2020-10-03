package io.github.vlad324.n430;

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
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
