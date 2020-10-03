package io.github.vlad324.n318;

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
            arguments(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}, 16)
//            arguments(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}, 4),
//            arguments(new String[]{"a", "aa", "aaa", "aaaa"}, 0),
//            arguments(new String[]{"eae", "ea", "aaf", "bda", "fcf", "dc", "ac", "ce", "cefde", "dabae"}, 15)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String[] words, int expected) {
        // when
        final var actual = solution.maxProduct(words);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}