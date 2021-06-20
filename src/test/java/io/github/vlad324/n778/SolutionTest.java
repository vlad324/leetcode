package io.github.vlad324.n778;

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
                {0, 2},
                {1, 3}
            }, 3))
            .add(arguments(new int[][]{
                {0, 3},
                {1, 2}
            }, 2))
            .add(arguments(new int[][]{
                {3, 2},
                {1, 0}
            }, 3))
            .add(arguments(new int[][]{
                {0, 1, 2, 3, 4},
                {24, 23, 22, 21, 5},
                {12, 13, 14, 15, 16},
                {11, 17, 18, 19, 20},
                {10, 9, 8, 7, 6}
            }, 16))
            .add(arguments(new int[][]{
                {7, 23, 21, 9, 5},
                {3, 20, 8, 18, 15},
                {14, 13, 1, 0, 22},
                {2, 10, 24, 17, 12},
                {6, 16, 19, 4, 11}
            }, 17))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[][] grid, int expected) {
        // when
        final var actual = solution.swimInWater(grid);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}