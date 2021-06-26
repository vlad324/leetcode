package io.github.vlad324.n684;

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
            .add(arguments(new int[][]{{1, 2}, {1, 3}, {2, 3}}, new int[]{2, 3}))
            .add(arguments(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}}, new int[]{1, 4}))
            .add(arguments(new int[][]{{9, 10}, {5, 8}, {2, 6}, {1, 5}, {3, 8}, {4, 9}, {8, 10},
                {4, 10}, {6, 8}, {7, 9}}, new int[]{4, 10}))
            .build();
    }


    /// 9 - 10 5-8

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[][] edges, int[] expected) {
        // when
        final var actual = solution.findRedundantConnection(edges);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}