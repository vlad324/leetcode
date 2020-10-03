package io.github.vlad324.n1462;

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
        return Stream.of(
            arguments(2, new int[][]{{1, 0}}, new int[][]{{0, 1}, {1, 0}}, List.of(false, true)),
            arguments(2, new int[][]{}, new int[][]{{0, 1}, {1, 0}}, List.of(false, false)),
            arguments(3, new int[][]{{1, 2}, {1, 0}, {2, 0}}, new int[][]{{1, 0}, {1, 2}}, List.of(true, true)),
            arguments(3, new int[][]{{1, 0}, {2, 0}}, new int[][]{{0, 1}, {2, 0}}, List.of(false, true)),
            arguments(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}}, new int[][]{{0, 4}, {4, 0}, {1, 3}, {3, 0}},
                List.of(true, false, true, false))
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int n, int[][] prerequisites, int[][] queries, List<Boolean> expected) {
        // when
        final var actual = solution.checkIfPrerequisite(n, prerequisites, queries);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}