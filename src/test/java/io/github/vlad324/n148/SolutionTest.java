package io.github.vlad324.n148;

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
                linkedList(4, 2, 1, 3),
                linkedList(1, 2, 3, 4)
            ))
            .add(arguments(
                linkedList(-1, 5, 3, 4, 0),
                linkedList(-1, 0, 3, 4, 5)
            ))
            .add(arguments(
                linkedList(),
                linkedList()
            ))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(ListNode head, ListNode expected) {
        // when
        final var actual = solution.sortList(head);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}