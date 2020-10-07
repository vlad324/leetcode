package io.github.vlad324.n430;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.vlad324.n430.Solution.Node;
import org.junit.jupiter.api.Test;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void should_produce_expected_result() {
        // given
        final var head = buildList();
        final var expected = buildExpected();

        // when
        final var actual = solution.flatten(head);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private Node buildList() {
        final var node1 = new Node(1);
        final var node2 = new Node(2);
        final var node3 = new Node(3);
        final var node4 = new Node(4);
        final var node5 = new Node(5);
        final var node6 = new Node(6);
        final var node7 = new Node(7);
        final var node8 = new Node(8);
        final var node9 = new Node(9);
        final var node10 = new Node(10);
        final var node11 = new Node(11);
        final var node12 = new Node(12);

        // level 1
        node1.next = node2;

        node2.prev = node1;
        node2.next = node3;

        node3.prev = node2;
        node3.next = node4;
        node3.child = node7;

        node4.prev = node3;
        node4.next = node5;

        node5.prev = node4;
        node5.next = node6;

        node6.prev = node5;


        // level 2
        node7.next = node8;

        node8.prev = node7;
        node8.next = node9;
        node8.child = node11;

        node9.prev = node8;
        node9.next = node10;

        node10.prev = node9;

        // level 3
        node11.next = node12;

        node12.prev = node11;

        return node1;
    }

    private Node buildExpected() {
        final var node1 = new Node(1);
        final var node2 = new Node(2);
        final var node3 = new Node(3);
        final var node4 = new Node(4);
        final var node5 = new Node(5);
        final var node6 = new Node(6);
        final var node7 = new Node(7);
        final var node8 = new Node(8);
        final var node9 = new Node(9);
        final var node10 = new Node(10);
        final var node11 = new Node(11);
        final var node12 = new Node(12);

        node1.next = node2;

        node2.prev = node1;
        node2.next = node3;

        node3.prev = node2;
        node3.next = node7;

        node7.prev = node3;
        node7.next = node8;

        node8.prev = node7;
        node8.next = node11;

        node11.prev = node8;
        node11.next = node12;

        node12.prev = node11;
        node12.next = node9;

        node9.prev = node12;
        node9.next = node10;

        node10.prev = node9;
        node10.next = node4;

        node4.prev = node10;
        node4.next = node5;

        node5.prev = node4;
        node5.next = node6;

        node6.prev = node5;

        return node1;
    }
}