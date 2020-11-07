package io.github.vlad324.n445;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.n445.Solution.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    // [2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,9]
    // [5,6,4,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,9,9,9,9]
    // [8,0,7,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,7,2,4,3,8]

    private static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments(
                new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3)))),
                                new ListNode(5, new ListNode(6, new ListNode(4))),
                new ListNode(7, new ListNode(8, new ListNode(0, new ListNode(7))))
            ))
            .add(arguments(
                new ListNode(5),
                new ListNode(5),
                new ListNode(1, new ListNode(0))
            ))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(ListNode l1, ListNode l2, ListNode expected) {
        // when
        final var actual = solution.addTwoNumbers(l1, l2);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}