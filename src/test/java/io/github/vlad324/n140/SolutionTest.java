package io.github.vlad324.n140;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
            arguments("catsanddog", List.of("cat", "cats", "and", "sand", "dog"),
                List.of(
                    "cats and dog",
                    "cat sand dog"
                )),
            arguments("pineapplepenapple", List.of("apple", "pen", "applepen", "pine", "pineapple"),
                List.of(
                    "pine apple pen apple",
                    "pineapple pen apple",
                    "pine applepen apple"
                )),
            arguments("catsandog", List.of("cats", "dog", "sand", "and", "cat"), Collections.emptyList())
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String s, List<String> wordDict, List<String> expected) {
        // when
        final var actual = solution.wordBreak(s, wordDict);

        // then
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }
}