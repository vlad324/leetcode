package io.github.vlad324.n142;

import io.github.vlad324.common.ListNode;

/**
 * {@link "https://leetcode.com/problems/linked-list-cycle-ii/"}
 */
class Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        var hare = head;
        var tortoise = head;

        do {
            if (hare.next == null || hare.next.next == null) {
                return null;
            }

            hare = hare.next.next;
            tortoise = tortoise.next;
        } while (hare != tortoise);

        tortoise = head;

        while (tortoise != hare) {
            hare = hare.next;
            tortoise = tortoise.next;
        }

        return hare;
    }
}
