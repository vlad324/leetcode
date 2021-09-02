package io.github.vlad324.n876;

import io.github.vlad324.common.ListNode;

/**
 * {@link "https://leetcode.com/problems/middle-of-the-linked-list/"}
 */
class Solution {

    public ListNode middleNode(ListNode head) {
        var slow = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
