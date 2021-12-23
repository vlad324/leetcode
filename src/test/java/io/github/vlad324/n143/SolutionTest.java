package io.github.vlad324.n143;

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
            .add(arguments(linkedList(1), linkedList(1)))
            .add(arguments(linkedList(1, 2), linkedList(1, 2)))
            .add(arguments(linkedList(1, 2, 3), linkedList(1, 3, 2)))
            .add(arguments(linkedList(1, 2, 3, 4), linkedList(1, 4, 2, 3)))
            .add(arguments(linkedList(1, 2, 3, 4, 5), linkedList(1, 5, 2, 4, 3)))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(ListNode head, ListNode expected) {
        // when
        solution.reorderList(head);

        // then
        assertThat(head).isEqualTo(expected);
    }

}