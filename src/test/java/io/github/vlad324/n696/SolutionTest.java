package io.github.vlad324.n696;

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
            .add(arguments("00110011", 6))
            .add(arguments("10101", 4))
            .add(arguments("00011100", 5))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String s, int expected) {
        // when
        final var actual = solution.countBinarySubstrings(s);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}