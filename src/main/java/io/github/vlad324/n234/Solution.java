package io.github.vlad324.n234;

/**
 * {@link "https://leetcode.com/problems/palindrome-linked-list/"}
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        var fast = head;
        var slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        var reversedHead = reverseList(slow);
        while (reversedHead != null) {
            if (head.val != reversedHead.val) {
                return false;
            }
            head = head.next;
            reversedHead = reversedHead.next;
        }

        return true;
    }

    private ListNode reverseList(ListNode slow) {
        ListNode previous = null;
        while (slow != null) {
            var next = slow.next;
            slow.next = previous;
            previous = slow;
            slow = next;
        }

        return previous;
    }

    public static class ListNode {
        private int val;
        private ListNode next;

        ListNode(int val) {
            this(val, null);
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
