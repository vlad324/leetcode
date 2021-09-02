package io.github.vlad324.n92;

import io.github.vlad324.common.ListNode;

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
}
