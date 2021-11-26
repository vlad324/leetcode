package io.github.vlad324.n797;

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
            .add(arguments(new int[][]{{1, 2}, {3}, {3}, {}},
                List.of(List.of(0, 1, 3), List.of(0, 2, 3))))
            .add(arguments(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}},
                List.of(List.of(0, 4), List.of(0, 3, 4), List.of(0, 1, 3, 4), List.of(0, 1, 2, 3, 4), List.of(0, 1, 4))))
            .add(arguments(new int[][]{{1}, {}},
                List.of(List.of(0, 1))))
            .add(arguments(new int[][]{{}, {0}},
                List.of()))
            .add(arguments(new int[][]{{1, 2, 3}, {2}, {3}, {}},
                List.of(List.of(0, 1, 2, 3), List.of(0, 2, 3), List.of(0, 3))))
            .add(arguments(new int[][]{{1, 3}, {2}, {3}, {}},
                List.of(List.of(0, 1, 2, 3), List.of(0, 3))))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[][] graph, List<List<Integer>> expected) {
        // when
        final var actual = solution.allPathsSourceTarget(graph);

        // then
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }
}