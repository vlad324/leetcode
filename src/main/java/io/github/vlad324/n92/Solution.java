package io.github.vlad324.n92;

import java.util.Objects;

/**
 * {@link "https://leetcode.com/problems/reverse-linked-list-ii/"}
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        var node = head;
        ListNode prev = null;
        while (left > 1) {
            prev = node;
            node = node.next;
            left--;
            right--;
        }

        var preLeft = prev;
        var last = node;

        while (right > 0) {
            var temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
            right--;
        }

        last.next = node;

        if (preLeft != null) {
            preLeft.next = prev;
            return head;
        }

        return prev;
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

        @Override
        public String toString() {
            return "{" +
                "val=" + val +
                ", next=" + next +
                '}';
        }
    }
}
