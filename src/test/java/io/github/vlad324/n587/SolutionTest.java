package io.github.vlad324.n587;

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
                new int[][]{{1, 1}, {2, 2}, {2, 0}, {2, 4}, {3, 3}, {4, 2}},
                new int[][]{{1, 1}, {2, 0}, {3, 3}, {2, 4}, {4, 2}}
            ))
            .add(arguments(
                new int[][]{{1, 2}, {2, 2}, {4, 2}},
                new int[][]{{4, 2}, {2, 2}, {1, 2}}
            ))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[][] trees, int[][] expected) {
        // when
        final var actual = solution.outerTrees(trees);

        // then
        assertThat(actual).containsExactlyInAnyOrder(expected);
    }

    // new int[][]{{1,1},{2,2},{2,0},{2,4},{3,3},{4,2}}
    // new int[][]{{1,1},{2,0},{3,3},{2,4},{4,2}}
    // new int[][]{{1,2},{2,2},{4,2}}
    // new int[][]{{4,2},{2,2},{1,2}}

}