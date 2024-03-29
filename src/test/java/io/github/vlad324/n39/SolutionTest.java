package io.github.vlad324.n39;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments(new int[]{2, 3, 6, 7}, 7, List.of(List.of(2, 2, 3), List.of(7))))
            .add(arguments(new int[]{2, 3, 5}, 8, List.of(List.of(2, 2, 2, 2), List.of(2, 3, 3), List.of(3, 5))))
            .add(arguments(new int[]{2}, 1, List.of()))
            .add(arguments(new int[]{1}, 1, List.of(List.of(1))))
            .add(arguments(new int[]{1}, 2, List.of(List.of(1, 1))))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] candidates, int target, List<List<Integer>> expected) {
        // when
        final var actual = solution.combinationSum(candidates, target);

        // then
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }
}