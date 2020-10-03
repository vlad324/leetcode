package io.github.vlad324;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SquareSubmatricesTest {

    private final SquareSubmatrices squareSubmatrices = new SquareSubmatrices();

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[][] matrix, int expectedResult) {
        // when
        final var actualResult = squareSubmatrices.countSquares(matrix);

        // then
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> testDataProvider() {
        int[][] matrix1 = {
            {0, 1, 1, 1},
            {1, 1, 1, 1},
            {0, 1, 1, 1}
        };

        int[][] matrix2 = {
            {1, 0, 1},
            {1, 1, 0},
            {1, 1, 0}
        };

        int[][] matrix3 = {
            {0, 1, 1, 1},
            {1, 1, 0, 1},
            {0, 1, 1, 1}
        };

        int[][] matrix4 = {
            {0}
        };

        int[][] matrix5 = {
            {1}
        };

        return Stream.of(
            arguments(matrix2, 7),
            arguments(matrix1, 15),
            arguments(matrix3, 9),
            arguments(matrix4, 0),
            arguments(matrix5, 1)
        );
    }
}