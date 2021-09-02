package io.github.vlad324.n147;

import io.github.vlad324.common.ListNode;

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
}
