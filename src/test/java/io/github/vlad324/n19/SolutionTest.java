package io.github.vlad324.n19;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.n19.Solution.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments(
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))),
                2,
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(5))))
            ))
            .add(arguments(
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))),
                5,
                new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))
            ))
            .add(arguments(
                new ListNode(1),
                1,
                null
            ))
            .add(arguments(
                new ListNode(1, new ListNode(2)),
                1,
                new ListNode(1)
            ))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(ListNode head, int n, ListNode expected) {
        // when
        final var actual = solution.removeNthFromEnd(head, n);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}