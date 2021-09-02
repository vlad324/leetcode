package io.github.vlad324.n86;

import io.github.vlad324.common.ListNode;

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
}