package io.github.vlad324.n336;

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
            arguments(new String[]{"abcd", "dcba", "lls", "s", "sssll"},
                List.of(
                    List.of(0, 1),
                    List.of(1, 0),
                    List.of(3, 2),
                    List.of(2, 4)
                )),
            arguments(new String[]{"bat", "tab", "cat"},
                List.of(
                    List.of(0, 1),
                    List.of(1, 0)
                )),
            arguments(new String[]{"a", ""},
                List.of(
                    List.of(0, 1),
                    List.of(1, 0)
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String[] words, List<List<Integer>> expected) {
        // when
        final var actual = solution.palindromePairs(words);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> isPalindromeTestDataProvider() {
        return Stream.of(
            arguments("abcd", "dcba", true),
            arguments("dcba", "abcd", true),
            arguments("lls", "sssll", true),
            arguments("s", "lls", true),
            arguments("a", "", true),
            arguments("", "a", true),
            arguments("ab", "cd", false)
        );
    }

    @ParameterizedTest
    @MethodSource("isPalindromeTestDataProvider")
    void should_return_expected_result_for_isPalindrome_call(String w1, String w2, boolean expected) {
        // when
        final var actual = solution.isPalindrome(w1, w2);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}