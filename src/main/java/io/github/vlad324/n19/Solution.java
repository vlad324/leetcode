package io.github.vlad324.n19;

import io.github.vlad324.common.ListNode;

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

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        int size = 0;
        var node = head;
        while (node != null) {
            size++;
            node = node.next;
        }

        int leave = size - n;

        ListNode prev = null;
        node = head;
        while (leave > 0) {
            prev = node;
            node = node.next;
            leave--;
        }

        if (prev == null) {
            return node.next;
        }

        prev.next = node.next;

        return head;
    }
}
