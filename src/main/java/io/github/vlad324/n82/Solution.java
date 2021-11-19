package io.github.vlad324.n82;

import io.github.vlad324.common.ListNode;

/**
 * {@link "https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/"}
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        final var holder = new ListNode(Integer.MAX_VALUE, head);
        var prev = holder;
        var node = holder.next;
        while (node != null && node.next != null) {
            if (node.val == node.next.val) {
                while (node.next != null && node.val == node.next.val) {
                    node = node.next;
                }
                prev.next = node.next;
            } else {
                prev = node;
            }
            node = node.next;
        }

        return holder.next;
    }
}
