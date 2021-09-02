package io.github.vlad324.n21;

import io.github.vlad324.common.ListNode;

/**
 * {@link "https://leetcode.com/problems/merge-two-sorted-lists/"}
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        var node = new ListNode(-1);
        final var result = node;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }

            node = node.next;
            node.next = null;
        }

        if (l1 != null) {
            node.next = l1;
        }

        if (l2 != null) {
            node.next = l2;
        }

        return result.next;
    }
}
