package io.github.vlad324.n329;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments(new int[][]{
                    {9, 9, 4},
                    {6, 6, 8},
                    {2, 1, 1}},
                4))
            .add(arguments(new int[][]{
                    {3, 4, 5},
                    {3, 2, 6},
                    {2, 2, 1}},
                4))
            .add(arguments(new int[][]{{1}}, 1))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[][] matrix, int expected) {
        // when
        final var actual = solution.longestIncreasingPath(matrix);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}