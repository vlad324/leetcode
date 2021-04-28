package io.github.vlad324.n63;

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
                    {0, 0, 0},
                    {0, 1, 0},
                    {0, 0, 0}},
                2))
            .add(arguments(new int[][]{
                    {0, 1, 0},
                    {0, 0, 0},
                    {0, 0, 0}},
                3))
            .add(arguments(new int[][]{
                    {0, 0, 0},
                    {0, 0, 0},
                    {0, 0, 0}},
                6))
            .add(arguments(new int[][]{
                    {0, 1},
                    {0, 0}},
                1))
            .add(arguments(new int[][]{
                    {0, 0},
                    {0, 1}},
                0))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[][] obstacleGrid, int expected) {
        // when
        final var actual = solution.uniquePathsWithObstacles(obstacleGrid);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}