package io.github.vlad324.n19;

import java.util.Objects;

/**
 * {@link "https://leetcode.com/problems/remove-nth-node-from-end-of-list/"}
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        int count = 0;
        var node = head;
        var preRemove = head;
        while (node != null) {
            if (count > n) {
                preRemove = preRemove.next;
            }

            node = node.next;
            count++;
        }

        if (count > n) {
            preRemove.next = preRemove.next == null ? null : preRemove.next.next;
        } else {
            head = head.next;
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
            return val == listNode.val && Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }
}
