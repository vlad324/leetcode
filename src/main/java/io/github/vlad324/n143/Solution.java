package io.github.vlad324.n143;

import io.github.vlad324.common.ListNode;

import java.util.Stack;

/**
 * {@link "https://leetcode.com/problems/reorder-list/"}
 */
class Solution {
    public void reorderList(ListNode head) {
        final var stack = new Stack<ListNode>();
        var node = head;
        int size = 0;
        while (node != null) {
            stack.push(node);
            size++;
            node = node.next;
        }

        size /= 2;
        node = head;
        while (size != 0) {
            var temp = node.next;
            node.next = stack.pop();
            node.next.next = temp;
            node = temp;
            size--;
        }
        node.next = null;
    }
}
