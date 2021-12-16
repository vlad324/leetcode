package io.github.vlad324.n310;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}, List.of(1)))
            .add(arguments(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}}, List.of(3, 4)))
            .add(arguments(1, new int[][]{}, List.of(0)))
            .add(arguments(2, new int[][]{{0, 1}}, List.of(0, 1)))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int n, int[][] edges, List<Integer> expected) {
        // when
        final var actual = solution.findMinHeightTrees(n, edges);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}