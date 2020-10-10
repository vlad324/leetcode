package io.github.vlad324.n452;

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
            .add(arguments(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}, 2))
            .add(arguments(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}, 4))
            .add(arguments(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}, 2))
            .add(arguments(new int[][]{{1, 2}}, 1))
            .add(arguments(new int[][]{{2, 3}, {2, 3}}, 1))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[][] points, int expected) {
        // when
        final var actual = solution.findMinArrowShots(points);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}