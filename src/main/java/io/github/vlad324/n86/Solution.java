package io.github.vlad324.n86;

import java.util.Objects;

/**
 * {@link "https://leetcode.com/problems/partition-list/"}
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        final var lower = new ListNode(-1);
        var currentLower = lower;
        final var higher = new ListNode(-1);
        var currentHigher = higher;

        var node = head;
        while (node != null) {
            if (node.val < x) {
                currentLower.next = node;
                currentLower = currentLower.next;
            } else {
                currentHigher.next = node;
                currentHigher = currentHigher.next;
            }

            node = node.next;
        }

        currentHigher.next = null;
        currentLower.next = higher.next;

        return lower.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this(val, null);
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final ListNode listNode = (ListNode) o;
            return val == listNode.val && Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }
}