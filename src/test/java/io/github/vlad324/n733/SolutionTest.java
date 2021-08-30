package io.github.vlad324.n733;

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
            .add(arguments(
                new int[][]{
                    {1, 1, 1},
                    {1, 1, 0},
                    {1, 0, 1}
                },
                1, 1, 2,
                new int[][]{
                    {2, 2, 2},
                    {2, 2, 0},
                    {2, 0, 1}
                }))
            .add(arguments(
                new int[][]{
                    {0, 0, 0},
                    {0, 0, 0}
                },
                0, 0, 2,
                new int[][]{
                    {2, 2, 2},
                    {2, 2, 2}
                }))
            .add(arguments(
                new int[][]{
                    {0, 0, 0},
                    {0, 1, 1}
                },
                1, 1, 1,
                new int[][]{
                    {0, 0, 0},
                    {0, 1, 1}
                }))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[][] image, int sr, int sc, int newColor, int[][] expected) {
        // when
        final var actual = solution.floodFill(image, sr, sc, newColor);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result_dfs(int[][] image, int sr, int sc, int newColor, int[][] expected) {
        // when
        final var actual = solution.floodFill_dfs(image, sr, sc, newColor);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}