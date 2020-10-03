package io.github.vlad324.n520;

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
            arguments("USA", true),
            arguments("leetcode", true),
            arguments("Google", true),
            arguments("FlaG", false)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String word, boolean expected) {
        // when
        final var actual = solution.detectCapitalUse(word);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}