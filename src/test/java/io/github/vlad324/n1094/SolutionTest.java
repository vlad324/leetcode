package io.github.vlad324.n1094;

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
            .add(arguments(new int[][]{{1, 0, 1}}, 1, true))
            .add(arguments(new int[][]{{2, 0, 1}}, 1, false))
            .add(arguments(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4, false))
            .add(arguments(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5, true))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[][] trips, int capacity, boolean expected) {
        // when
        final var actual = solution.carPooling(trips, capacity);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}