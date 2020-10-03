package io.github.vlad324.n973;

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
            arguments(new int[][]{{1, 3}, {-2, 2}}, 1, new int[][]{{-2, 2}}),
            arguments(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2, new int[][]{{3, 3}, {-2, 4}}),
            arguments(new int[][]{}, 0, new int[][]{})
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[][] points, int k, int[][] expected) {
        // when
        final var actual = solution.kClosest(points, k);

        // then
        assertThat(actual).containsExactlyInAnyOrder(expected);
    }

}