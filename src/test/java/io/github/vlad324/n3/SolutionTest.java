package io.github.vlad324.n3;

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
            .add(arguments("", 0))
            .add(arguments("abcabcbb", 3))
            .add(arguments("bbbbb", 1))
            .add(arguments("pwwkew", 3))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String s, int expected) {
        // when
        final var actual = solution.lengthOfLongestSubstring(s);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}