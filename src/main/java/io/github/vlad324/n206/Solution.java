package io.github.vlad324.n206;

import io.github.vlad324.common.ListNode;

/**
 * {@link "https://leetcode.com/problems/reverse-linked-list/"}
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        return reverseList(null, head);
    }

    private ListNode reverseList(ListNode prev, ListNode current) {
        if (current.next == null) {
            current.next = prev;
            return current;
        }

        final var next = current.next;
        current.next = prev;

        return reverseList(current, next);
    }
}
