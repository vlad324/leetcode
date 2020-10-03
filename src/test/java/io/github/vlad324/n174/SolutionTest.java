package io.github.vlad324.n174;

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
            arguments(new int[][]{
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5},
            }, 7),
            arguments(new int[][]{
                {100},
            }, 1),
            arguments(new int[][]{
                {-100, 200},
                {-200, -50},
            }, 101)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[][] dungeon, int expected) {
        // when
        final var actual = solution.calculateMinimumHP(dungeon);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}