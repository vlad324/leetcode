package io.github.vlad324.n876;

import java.util.Objects;

/**
 * {@link "https://leetcode.com/problems/middle-of-the-linked-list/"}
 */
class Solution {

    public ListNode middleNode(ListNode head) {
        var slow = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    static class ListNode {
        public final int val;
        public final ListNode next;

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
            return val == listNode.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val);
        }

        @Override
        public String toString() {
            return "ListNode{" +
                "val=" + val +
                '}';
        }
    }
}
