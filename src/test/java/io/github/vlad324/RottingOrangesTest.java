package io.github.vlad324;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RottingOrangesTest {

    private final RottingOranges rottingOranges = new RottingOranges();

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
            arguments(new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
            }, 4),
            arguments(new int[][]{
                {0, 2},
            }, 0),
            arguments(new int[][]{
                {2, 1, 1},
                {0, 0, 1},
                {1, 1, 0},
            }, -1),
            arguments(new int[][]{
                {2, 1, 2, 2, 2, 0, 0, 1, 1},
                {2, 1, 2, 2, 1, 2, 1, 1, 1},
                {1, 1, 0, 2, 2, 1, 0, 0, 0}
            }, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_return_expected_result(int[][] grid, int expected) {
        // when
        final var actual = rottingOranges.orangesRotting(grid);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}