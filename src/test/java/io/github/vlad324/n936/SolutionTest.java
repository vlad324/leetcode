package io.github.vlad324.n936;

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
            .add(arguments("abc", "ababc", new int[]{0, 2}))
            .add(arguments("abca", "aabcaca", new int[]{0, 3, 1}))
            .add(arguments("abc", "abc", new int[]{0}))
            .add(arguments("acb", "abc", new int[]{}))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String stamp, String target, int[] expected) {
        // when
        final var actual = solution.movesToStamp(stamp, target);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}