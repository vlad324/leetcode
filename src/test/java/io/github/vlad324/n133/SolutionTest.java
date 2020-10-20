package io.github.vlad324.n133;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.vlad324.n133.Solution.Node;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void should_produce_expected_result() {
        // given
        final var one = new Node(1);
        final var two = new Node(2);
        final var three = new Node(3);
        final var four = new Node(4);

        one.neighbors.add(two);
        one.neighbors.add(four);

        two.neighbors.add(one);
        two.neighbors.add(three);

        three.neighbors.add(two);
        two.neighbors.add(four);

        four.neighbors.add(one);
        four.neighbors.add(three);

        // when
        final var node = solution.cloneGraph(one);

        // then
        assertThat(node).isNotSameAs(one);
    }
}