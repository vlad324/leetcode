package io.github.vlad324.n621;

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
            arguments(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2, 8),
            arguments(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0, 6),
            arguments(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2, 16)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(char[] tasks, int n, int expected) {
        // when
        final var actual = solution.leastInterval(tasks, n);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}