package io.github.vlad324.n66;

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
            arguments(new int[]{1, 2, 3}, new int[]{1, 2, 4}),
            arguments(new int[]{9, 9}, new int[]{1, 0, 0}),
            arguments(new int[]{0}, new int[]{1})
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] digits, int[] expected) {
        // when
        final var actual = solution.plusOne(digits);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}