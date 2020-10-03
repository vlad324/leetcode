package io.github.vlad324.n1461;

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
            arguments("00110110", 2, true),
            arguments("00110", 2, true),
            arguments("0110", 1, true),
            arguments("0110", 2, false),
            arguments("0000000001011100", 4, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String s, int k, boolean expected) {
        // when
        final var actual = solution.hasAllCodes(s, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}