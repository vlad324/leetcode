package io.github.vlad324.n48;

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
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
                },
                new int[][]{
                    {7, 4, 1},
                    {8, 5, 2},
                    {9, 6, 3}
                }))
            .add(arguments(
                new int[][]{
                    {5, 1, 9, 11},
                    {2, 4, 8, 10},
                    {13, 3, 6, 7},
                    {15, 14, 12, 16}
                },
                new int[][]{
                    {15, 13, 2, 5},
                    {14, 3, 4, 1},
                    {12, 6, 8, 9},
                    {16, 7, 10, 11}
                }))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[][] matrix, int[][] expected) {
        // when
        solution.rotate(matrix);

        // then
        assertThat(matrix).isEqualTo(expected);
    }

}