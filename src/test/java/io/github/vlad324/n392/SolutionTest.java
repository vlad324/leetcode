package io.github.vlad324.n392;

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
            arguments("abc", "ahbgdc", true),
            arguments("axc", "ahbgdc", false),
            arguments("", "ahbgdc", true),
            arguments("", "", true),
            arguments("a", "", false)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String s, String t, boolean expected) {
        // when
        final var actual = solution.isSubsequence(s, t);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}