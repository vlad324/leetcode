package io.github.vlad324.common;

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
}
