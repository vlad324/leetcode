package io.github.vlad324.n845;

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
            .add(arguments(new int[]{2, 1, 4, 7, 3, 2, 5}, 5))
            .add(arguments(new int[]{2, 2, 2}, 0))
            .add(arguments(new int[]{2, 3, 2}, 3))
            .add(arguments(new int[]{2, 3, 2, 4, 5, 6, 3}, 5))
            .add(arguments(new int[]{2, 4, 5, 6, 3, 4, 6}, 5))
            .add(arguments(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 0))
            .add(arguments(new int[]{0, 1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 3))
            .add(arguments(new int[]{0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0}, 11))
            .add(arguments(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, 0))
            .add(arguments(new int[]{1, 1, 0, 0, 1, 0}, 3))
            .add(arguments(new int[]{2, 3, 3, 2, 0, 2}, 0))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] a, int expected) {
        // when
        final var actual = solution.longestMountain(a);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}