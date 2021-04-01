package io.github.vlad324.n234;

import java.util.ArrayList;

/**
 * {@link "https://leetcode.com/problems/palindrome-linked-list/"}
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        final var list = new ArrayList<Integer>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        final var size = list.size();
        for (int i = 0; i < size / 2; i++) {
            if (!list.get(i).equals(list.get(size - 1 - i))) {
                return false;
            }
        }

        return true;
    }

    public static class ListNode {
        private final int val;
        private final ListNode next;

        ListNode(int val) {
            this(val, null);
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
