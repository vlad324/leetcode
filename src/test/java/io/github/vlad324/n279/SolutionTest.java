package io.github.vlad324.n279;

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
            arguments(2, 2),
            arguments(3, 3),
            arguments(4, 1),
            arguments(5, 2),
            arguments(12, 3),
            arguments(13, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int n, int expected) {
        // when
        final var actual = solution.numSquares(n);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}