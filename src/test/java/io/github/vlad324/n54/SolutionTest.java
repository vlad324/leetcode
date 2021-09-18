package io.github.vlad324.n54;

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
            .add(arguments(new int[][]{
                {1}
            }, List.of(1)))
            .add(arguments(new int[][]{
                {1, 2, 3, 4, 5}
            }, List.of(1, 2, 3, 4, 5)))
            .add(arguments(new int[][]{
                {1},
                {2},
                {3},
                {4},
                {5}
            }, List.of(1, 2, 3, 4, 5)))
            .add(arguments(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            }, List.of(1, 2, 3, 6, 9, 8, 7, 4, 5)))
            .add(arguments(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
            }, List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[][] matrix, List<Integer> expected) {
        // when
        final var actual = solution.spiralOrder(matrix);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}