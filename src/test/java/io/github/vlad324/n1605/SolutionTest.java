package io.github.vlad324.n1605;

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
            .add(arguments(new int[]{3, 8}, new int[]{4, 7}, new int[][]{{3, 0}, {1, 7}}))
            .add(arguments(new int[]{5, 7, 10}, new int[]{8, 6, 8}, new int[][]{{0, 5, 0}, {6, 1, 0}, {2, 0, 8}}))
            .add(arguments(new int[]{14, 9}, new int[]{6, 9, 8}, new int[][]{{0, 9, 5}, {6, 0, 3}}))
            .add(arguments(new int[]{1, 0}, new int[]{1}, new int[][]{{1}, {0}}))
            .add(arguments(new int[]{0}, new int[]{0}, new int[][]{{0}}))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] rowSum, int[] colSum, int[][] expected) {
        // when
        final var actual = solution.restoreMatrix(rowSum, colSum);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}