package io.github.vlad324.n86;

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
            .add(arguments(
                linkedList(1, 4, 3, 2, 5, 2),
                3,
                linkedList(1, 2, 2, 4, 3, 5)
            ))
            .add(arguments(
                linkedList(2, 1),
                2,
                linkedList(1, 2)
            ))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(ListNode head, int x, ListNode expected) {
        // when
        final var actual = solution.partition(head, x);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}