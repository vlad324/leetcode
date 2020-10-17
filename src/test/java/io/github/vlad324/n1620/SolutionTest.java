package io.github.vlad324.n1620;

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
            .add(arguments(new int[][]{{1, 2, 5}, {2, 1, 7}, {3, 1, 9}}, 2, new int[]{2, 1}))
            .add(arguments(new int[][]{{40, 41, 12}, {18, 5, 2}}, 35, new int[]{40, 41}))
            .add(arguments(new int[][]{{31, 13, 33}, {24, 45, 38}, {28, 32, 23}, {7, 23, 22}, {41, 50, 33},
                {47, 21, 3}, {3, 33, 39}, {11, 38, 5}, {26, 20, 28}, {48, 39, 16}, {34, 29, 25}}, 21, new int[]{24, 45}))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[][] towers, int radius, int[] expected) {
        // when
        final var actual = solution.bestCoordinate(towers, radius);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}