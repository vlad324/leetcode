package io.github.vlad324.n207;

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
            arguments(2, new int[][]{{1, 0}}, true),
            arguments(2, new int[][]{{1, 0}, {0, 1}}, false),
            arguments(1, new int[][]{{0, 0}}, false),
            arguments(1, new int[][]{}, true),
            arguments(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}, {2, 1}}, true),
            arguments(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}, {0, 3}}, false),
            arguments(4, new int[][]{{0, 1}, {3, 1}, {1, 3}, {3, 2}}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int numCourses, int[][] prerequisites, boolean expected) {
        // when
        final var actual = solution.canFinish(numCourses, prerequisites);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}