package io.github.vlad324.n1463;

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
            arguments(new int[][]{
                {3, 1, 1},
                {2, 5, 1},
                {1, 5, 5},
                {2, 1, 1}
            }, 24),
            arguments(new int[][]{
                {1, 0, 0, 0, 0, 0, 1},
                {2, 0, 0, 0, 0, 3, 0},
                {2, 0, 9, 0, 0, 0, 0},
                {0, 3, 0, 5, 4, 0, 0},
                {1, 0, 2, 3, 0, 0, 6}
            }, 28),
            arguments(new int[][]{
                {1, 0, 0, 3},
                {0, 0, 0, 3},
                {0, 0, 3, 3},
                {9, 0, 3, 3},
            }, 22),
            arguments(new int[][]{
                {1, 1},
                {1, 1}
            }, 4),
            arguments(new int[][]{
                {8, 8, 10, 9, 1, 7},
                {8, 8, 1, 8, 4, 7},
                {8, 6, 10, 3, 7, 7},
                {3, 0, 9, 3, 2, 7},
                {6, 8, 9, 4, 2, 5},
                {1, 1, 5, 8, 8, 1},
                {5, 6, 5, 2, 9, 9},
                {4, 4, 6, 2, 5, 4},
                {4, 4, 5, 3, 1, 6},
                {9, 2, 2, 1, 9, 3}
            }, 146),
            arguments(new int[][]{
                {13, 15, 3, 9, 12, 11, 12, 11, 2, 15, 7, 8, 14, 0, 19, 2},
                {20, 20, 9, 16, 11, 19, 16, 19, 11, 18, 9, 10, 5, 13, 9, 5},
                {13, 11, 10, 0, 15, 0, 20, 15, 2, 11, 19, 4, 6, 20, 16, 15},
                {7, 18, 10, 1, 9, 20, 10, 11, 7, 6, 4, 5, 3, 4, 16, 17},
                {10, 7, 6, 15, 6, 0, 14, 20, 11, 19, 3, 4, 6, 10, 17, 3},
                {2, 3, 11, 2, 8, 19, 16, 19, 1, 12, 11, 10, 4, 10, 5, 20},
                {8, 8, 4, 2, 18, 10, 19, 5, 11, 5, 14, 15, 6, 3, 13, 3},
                {3, 10, 16, 0, 16, 9, 7, 19, 8, 11, 5, 5, 11, 14, 5, 4},
                {9, 20, 13, 8, 8, 10, 3, 13, 1, 14, 16, 6, 18, 17, 9, 5},
                {7, 2, 1, 4, 15, 6, 15, 16, 4, 4, 19, 17, 11, 1, 17, 20},
                {10, 8, 10, 4, 2, 20, 10, 17, 9, 12, 19, 11, 0, 20, 14, 7},
                {12, 10, 13, 18, 7, 9, 4, 18, 15, 13, 15, 1, 7, 13, 20, 10},
                {12, 15, 1, 1, 17, 17, 6, 8, 0, 19, 20, 5, 15, 17, 18, 18}
            }, 390)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[][] grid, int expected) {
        // when
        final var actual = solution.cherryPickup(grid);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}