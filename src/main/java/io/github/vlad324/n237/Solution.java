package io.github.vlad324.n237;

/**
 * {@link "https://leetcode.com/problems/delete-node-in-a-linked-list/"}
 */
class Solution {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }

        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }
    }

}
