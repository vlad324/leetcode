package io.github.vlad324.n395;

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
            .add(arguments("aaabb", 3, 3))
            .add(arguments("abacbb", 2, 2))
            .add(arguments("ababbc", 2, 5))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String s, int k, int expected) {
        // when
        final var actual = solution.longestSubstring(s, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}