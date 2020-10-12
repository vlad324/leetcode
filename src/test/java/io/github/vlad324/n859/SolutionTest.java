package io.github.vlad324.n859;

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
            .add(arguments("ab", "ba", true))
            .add(arguments("ab", "ab", false))
            .add(arguments("aa", "aa", true))
            .add(arguments("aaaaaaabc", "aaaaaaacb", true))
            .add(arguments("", "aa", false))
            .add(arguments("abcaa", "abcbb", false))
            .build();
    }


    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String A, String B, boolean expected) {
        // when
        final var actual = solution.buddyStrings(A, B);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}