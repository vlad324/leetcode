package io.github.vlad324.n72;

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
            arguments("rse", "ros", 2),
            arguments("rse", "sor", 3),
            arguments("horse", "ros", 3),
            arguments("intention", "execution", 5),
            arguments("", "", 0),
            arguments("123", "", 3),
            arguments("", "123", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String s1, String s2, int expected) {
        // when
        final var actual = solution.minDistance(s1, s2);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}