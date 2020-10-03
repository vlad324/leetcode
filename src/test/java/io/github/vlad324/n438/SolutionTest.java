package io.github.vlad324.n438;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class SolutionTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource({"simpleTestData", "veryLongOneLetterStringWithSecondLetterInTheMiddle", "alphabet"})
    void should_produce_expected_result(String s, String p, List<Integer> expected) {
        // when
        final var actual = solution.findAnagrams(s, p);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> simpleTestData() {
        return Stream.of(
            arguments("cbaebabacd", "abc", List.of(0, 6)),
            arguments("abab", "ab", List.of(0, 1, 2)),
            arguments("cbaebabacd", "aba", List.of(5)),
            arguments("cbaebabacd", "a", List.of(2, 5, 7)),
            arguments("aaa", "aa", List.of(0, 1)),
            arguments("aa", "aaa", Collections.emptyList()),
            arguments("af", "be", Collections.emptyList())
        );
    }

    private static Stream<Arguments> veryLongOneLetterStringWithSecondLetterInTheMiddle() {
        final var stringBuilder = new StringBuilder();
        stringBuilder.append("a".repeat(10_000));

        final var pattern = stringBuilder.toString();
        final var string = stringBuilder.append('b').append(stringBuilder).toString();

        return Stream.of(arguments(string, pattern, List.of(0, 10001)));
    }

    private static Stream<Arguments> alphabet() {
        final var expectedResult = IntStream.rangeClosed(0, 10062)
            .boxed()
            .collect(Collectors.toList());

        final var string = "abcdefghijklmnopqrstuvwxyz".repeat(773);
        final var pattern = "abcdefghijklmnopqrstuvwxyz".repeat(386);

        return Stream.of(arguments(string, pattern, expectedResult));
    }
}