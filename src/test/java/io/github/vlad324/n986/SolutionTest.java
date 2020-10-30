package io.github.vlad324.n986;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
            arguments(
                new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}},
                new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}},
                new int[][]{{1, 2}, {5, 5}, {8, 10}, {15, 23}, {24, 24}, {25, 25}}
            ),
            arguments(
                new int[][]{},
                new int[][]{},
                new int[][]{}
            ),
            arguments(
                new int[][]{{0, 1}},
                new int[][]{{2, 3}},
                new int[][]{}
            )
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[][] a, int[][] b, int[][] expected) {
        // when
        final var actual = solution.intervalIntersection(a, b);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}