package io.github.vlad324.n977;

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
            arguments(new int[]{-4, -1, 0, 3, 10}, new int[]{0, 1, 9, 16, 100}),
            arguments(new int[]{-7, -3, 2, 3, 11}, new int[]{4, 9, 9, 49, 121}),
            arguments(new int[]{-1}, new int[]{1})
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] a, int[] expected) {
        // when
        final var actual = solution.sortedSquares(a);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}