package io.github.vlad324;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RomanToIntegerTest {

    private final RomanToInteger romanToInteger = new RomanToInteger();

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_excepted_result(String input, int expected) {
        // when
        final var actual = romanToInteger.romanToInt(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
            arguments("III", 3),
            arguments("IV", 4),
            arguments("IX", 9),
            arguments("LVIII", 58),
            arguments("MCMXCIV", 1994)
        );
    }
}