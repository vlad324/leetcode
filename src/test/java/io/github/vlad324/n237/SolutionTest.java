package io.github.vlad324.n237;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
            arguments(new int[]{4, 5, 1, 9}, 5, List.of(4, 1, 9))
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] input, int toDelete, List<Integer> expected) {
        final var root = new ListNode(input[0]);
        ListNode node = root;
        ListNode current = root;
        int i = 1;
        while (i < input.length) {
            final var next = new ListNode(input[i]);

            if (input[i] == toDelete) {
                node = next;
            }

            current.next = next;
            current = next;
            i++;
        }


        // when
        solution.deleteNode(node);

        // then
        current = root;
        final var actual = new ArrayList<Integer>();
        while (current.next != null) {
            actual.add(current.val);
            current = current.next;
        }

        actual.add(current.val);

        assertThat(actual).isEqualTo(expected);
    }
}