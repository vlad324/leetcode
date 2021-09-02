package io.github.vlad324.n445;

import io.github.vlad324.common.ListNode;

import java.util.Stack;

/**
 * {@link "https://leetcode.com/problems/add-two-numbers-ii/"}
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final var s1 = getNumber(l1);
        if (s1.size() == 1 && s1.peek() == 0) {
            return l2;
        }

        final var s2 = getNumber(l2);
        if (s2.size() == 1 && s2.peek() == 0) {
            return l1;
        }

        return toList(s1, s2);
    }

    private ListNode toList(Stack<Integer> s1, Stack<Integer> s2) {
        ListNode result = null;
        int additional = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            int value = s1.pop() + s2.pop() + additional;
            additional = 0;

            if (value > 9) {
                additional = 1;
                value %= 10;
            }

            var tmp = result;
            result = new ListNode(value);
            result.next = tmp;
        }

        while (!s1.isEmpty()) {
            int value = s1.pop() + additional;
            additional = 0;

            if (value > 9) {
                additional = 1;
                value %= 10;
            }

            var tmp = result;
            result = new ListNode(value);
            result.next = tmp;
        }

        while (!s2.isEmpty()) {
            int value = s2.pop() + additional;
            additional = 0;

            if (value > 9) {
                additional = 1;
                value %= 10;
            }

            var tmp = result;
            result = new ListNode(value);
            result.next = tmp;
        }

        if (additional > 0) {
            var tmp = result;
            result = new ListNode(1);
            result.next = tmp;
        }

        return result;
    }

    private Stack<Integer> getNumber(ListNode l) {
        final var result = new Stack<Integer>();
        var node = l;
        while (node != null) {
            result.push(node.val);
            node = node.next;
        }

        return result;
    }
}
