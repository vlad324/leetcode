package io.github.vlad324.n142;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.vlad324.common.ListNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void should_produce_expected_result() {
        final var head = new ListNode(5);
        head.next = new ListNode(10);
        head.next.next = head;

        // when
        final var actual = solution.detectCycle(head);

        // then
        assertThat(actual).isEqualTo(head);
    }

    @Test
    void should_produce_expected_result2() {
        final var head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;

        // when
        final var actual = solution.detectCycle(head);

        // then
        assertThat(actual).isEqualTo(head.next);
    }
}