package io.github.vlad324.n109;

import io.github.vlad324.common.ListNode;

import java.util.Objects;

/**
 * {@link "https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/"}
 */
class Solution {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode preSlow = null;
        var slow = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            preSlow = slow;
            slow = slow.next;
        }

        if (preSlow != null) {
            preSlow.next = null;
        }

        return new TreeNode(slow.val, sortedListToBST(head), sortedListToBST(slow.next));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this(val, null, null);
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val &&
                Objects.equals(left, treeNode.left) &&
                Objects.equals(right, treeNode.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }

        @Override
        public String toString() {
            return "{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
        }
    }
}
