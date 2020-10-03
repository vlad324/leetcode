package io.github.vlad324.n171;

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
            arguments("A", 1),
            arguments("Z", 26),
            arguments("AA", 27),
            arguments("AB", 28),
            arguments("ZY", 701),
            arguments("FXSHRXW", 2147483647)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String s, int expected) {
        // when
        final var actual = solution.titleToNumber(s);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}