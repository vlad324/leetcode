package io.github.vlad324.n231;

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
            arguments(5, false),
            arguments(1, true),
            arguments(2, true),
            arguments(16, true),
            arguments(218, false),
            arguments(-1, false),
            arguments(-2147483648, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int number, boolean expected) {
        // when
        final var actual = solution.isPowerOfTwo(number);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}