package io.github.vlad324.common;

import java.util.ArrayDeque;

public final class CollectionUtils {

    public static ListNode linkedList(int... values) {
        if (values.length == 0) {
            return null;
        }

        final var head = new ListNode(0);
        var node = head;
        for (final int i : values) {
            node.next = new ListNode(i);
            node = node.next;
        }

        return head.next;
    }

    public static TreeNode tree(Integer... values) {
        if (values.length == 0) {
            return null;
        }

        final var head = new TreeNode(values[0]);
        final var queue = new ArrayDeque<TreeNode>();
        queue.offer(head);
        for (int i = 1; i < values.length; i++) {
            final var current = queue.poll();

            if (values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.offer(current.left);
            }

            if (i + 1 < values.length && values[++i] != null) {
                current.right = new TreeNode(values[i]);
                queue.offer(current.right);
            }
        }

        return head;
    }
}
