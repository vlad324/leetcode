package io.github.vlad324.n583;

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
            .add(arguments("sea", "eat", 2))
            .add(arguments("leetcode", "etco", 4))
            .add(arguments("a", "a", 0))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String word1, String word2, int expected) {
        // when
        final var actual = solution.minDistance(word1, word2);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}