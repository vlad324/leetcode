package io.github.vlad324.n1288;

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
            .add(arguments(new int[][]{{1, 4}, {3, 6}, {2, 8}}, 2))
            .add(arguments(new int[][]{{1, 4}, {2, 3}}, 1))
            .add(arguments(new int[][]{{0, 10}, {5, 12}}, 2))
            .add(arguments(new int[][]{{3, 10}, {4, 10}, {5, 11}}, 2))
            .add(arguments(new int[][]{{1, 2}, {1, 4}, {3, 4}}, 1))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[][] intervals, int expected) {
        // when
        final var actual = solution.removeCoveredIntervals(intervals);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}