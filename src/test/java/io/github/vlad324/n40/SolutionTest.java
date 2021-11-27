package io.github.vlad324.n40;

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
            .add(arguments(new int[]{10, 1, 2, 7, 6, 1, 5}, 8, List.of(List.of(1, 1, 6), List.of(1, 2, 5), List.of(1, 7), List.of(2, 6))))
            .add(arguments(new int[]{2, 5, 2, 1, 2}, 5, List.of(List.of(1, 2, 2), List.of(5))))
            .build();
    }


    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] candidates, int target, List<List<Integer>> expected) {
        // when
        final var actual = solution.combinationSum2(candidates, target);

        // then
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

}