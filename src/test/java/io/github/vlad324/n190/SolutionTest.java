package io.github.vlad324.n190;

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
            .add(arguments(0b00000010100101000001111010011100, 0b00111001011110000010100101000000))
            .add(arguments(0b11111111111111111111111111111101, 0b10111111111111111111111111111111))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int n, int expected) {
        // when
        final var actual = solution.reverseBits(n);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result_2(int n, int expected) {
        // when
        final var actual = solution.reverseBits2(n);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}