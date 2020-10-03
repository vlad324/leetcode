package io.github.vlad324.n139;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
            arguments("leetcode", List.of("leet", "code"), true),
            arguments("applepenapple", List.of("apple", "pen"), true),
            arguments("catsandog", List.of("cats", "dog", "sand", "and", "cat"), false)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String s, List<String> wordDict, boolean expected) {
        // when
        final var actual = solution.wordBreak(s, wordDict);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}