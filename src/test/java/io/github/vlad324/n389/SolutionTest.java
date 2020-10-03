package io.github.vlad324.n389;

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
            .add(arguments("abcd", "abcde", 'e'))
            .add(arguments("abcd", "abced", 'e'))
            .add(arguments("abcd", "adecb", 'e'))
            .add(arguments("a", "aa", 'a'))
            .add(arguments("aa", "aaa", 'a'))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String s, String t, char expected) {
        // when
        final var actual = solution.findTheDifference(s, t);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}