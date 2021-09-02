package io.github.vlad324.n61;

import io.github.vlad324.common.ListNode;

/**
 * {@link "https://leetcode.com/problems/rotate-list/"}
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int size = getSize(head);

        if (size == 0 || (k %= size) == 0) {
            return head;
        }

        int skipCount = size - k - 1;
        var next = head;
        while (skipCount != 0) {
            skipCount--;
            next = next.next;
        }

        final var newHead = next.next;
        next.next = null;

        next = newHead;
        while (next.next != null) {
            next = next.next;
        }
        next.next = head;

        return newHead;
    }

    private int getSize(ListNode head) {
        int size = 0;
        var next = head;
        while (next != null) {
            size++;
            next = next.next;
        }

        return size;
    }
}
