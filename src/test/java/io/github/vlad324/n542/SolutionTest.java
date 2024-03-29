package io.github.vlad324.n542;

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
                new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}},
                new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}
            ))
            .add(arguments(
                new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}},
                new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 2, 1}}
            ))
            .add(arguments(
                new int[][]{
                    {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                    {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                    {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                    {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                    {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                    {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                    {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                    {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                    {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}
                },
                new int[][]{
                    {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                    {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                    {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                    {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                    {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                    {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                    {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                    {1, 0, 0, 0, 1, 2, 1, 1, 0, 1},
                    {2, 1, 1, 1, 1, 2, 1, 0, 1, 0},
                    {3, 2, 2, 1, 0, 1, 0, 0, 1, 1}
                }
            ))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[][] matrix, int[][] expected) {
        // when
        final var actual = solution.updateMatrix(matrix);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    //
    //


}