package io.github.vlad324.n148;

import java.util.Objects;

/**
 * {@link "https://leetcode.com/problems/sort-list/"}
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        final var middle = getMiddle(head);
        final var head2 = middle.next;
        middle.next = null;

        return merge(sortList(head), sortList(head2));
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        final ListNode result;
        if (left.val < right.val) {
            result = left;
            left = left.next;
        } else {
            result = right;
            right = right.next;
        }

        var current = result;
        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }

            current = current.next;
        }

        if (left != null) {
            current.next = left;
        } else {
            current.next = right;
        }

        return result;
    }

    private ListNode getMiddle(ListNode head) {
        var slow = head;
        var fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
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
            return "" + val + (next == null ? "" : " " + next);
        }
    }
}
