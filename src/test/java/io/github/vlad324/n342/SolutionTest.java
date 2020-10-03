package io.github.vlad324.n342;

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
            arguments(16, true),
            arguments(5, false),
            arguments(3, false),
            arguments(1, true),
            arguments(0, false),
            arguments(64, true),
            arguments(17, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int num, boolean expected) {
        // when
        final var actual = solution.isPowerOfFour(num);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}