package io.github.vlad324.n21;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.n21.Solution.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments(
                new ListNode(-9, new ListNode(3)),
                new ListNode(5, new ListNode(7)),
                new ListNode(-9, new ListNode(3, new ListNode(5, new ListNode(7))))
            ))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(ListNode l1, ListNode l2, ListNode expected) {
        // when
        final var actual = solution.mergeTwoLists(l1, l2);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}