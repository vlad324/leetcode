package io.github.vlad324.n234;

import static io.github.vlad324.common.CollectionUtils.linkedList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments(linkedList(1, 2, 3, 2, 1), true))
            .add(arguments(linkedList(1, 2, 2, 1), true))
            .add(arguments(linkedList(1, 2), false))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(ListNode head, boolean expected) {
        // when
        final var actual = solution.isPalindrome(head);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}