package io.github.vlad324.n147;

import java.util.Objects;

/**
 * {@link "https://leetcode.com/problems/insertion-sort-list/"}
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev;
        var node = head;
        while (node.next != null) {
            prev = node;
            node = node.next;

            ListNode iPrev = null;
            var iNext = head;
            while (iNext.val < node.val) {
                iPrev = iNext;
                iNext = iNext.next;
            }

            if (iNext == node) {
                continue;
            }

            prev.next = node.next;

            if (iPrev == null) {
                node.next = iNext;
                head = node;
            } else {
                iPrev.next = node;
                node.next = iNext;
            }

            node = prev;
        }

        return head;
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
            return val == listNode.val &&
                Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }

        @Override
        public String toString() {
            return "{" +
                "val=" + val +
                ", next=" + next +
                '}';
        }
    }
}
