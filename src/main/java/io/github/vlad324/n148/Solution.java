package io.github.vlad324.n148;

import io.github.vlad324.common.ListNode;

/**
 * {@link "https://leetcode.com/problems/sort-list/"}
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        final var middle = getMiddle(head);
        final var head2 = middle.next;
        middle.next = null;

        return merge(sortList(head), sortList(head2));
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        final ListNode result;
        if (left.val < right.val) {
            result = left;
            left = left.next;
        } else {
            result = right;
            right = right.next;
        }

        var current = result;
        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }

            current = current.next;
        }

        if (left != null) {
            current.next = left;
        } else {
            current.next = right;
        }

        return result;
    }

    private ListNode getMiddle(ListNode head) {
        var slow = head;
        var fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
