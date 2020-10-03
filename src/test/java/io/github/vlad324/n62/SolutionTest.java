package io.github.vlad324.n62;

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
            arguments(3, 2, 3),
            arguments(7, 3, 28),
            arguments(23, 12, 193536720)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int m, int n, int expected) {
        // when
        final var actual = solution.uniquePaths(m, n);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}