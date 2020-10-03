package io.github.vlad324.n441;

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
            arguments(0, 0),
            arguments(1, 1),
            arguments(2, 1),
            arguments(3, 2),
            arguments(4, 2),
            arguments(5, 2),
            arguments(6, 3),
            arguments(7, 3),
            arguments(8, 3),
            arguments(1804289383, 60070)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int n, int expected) {
        // when
        final var actual = solution.arrangeCoins(n);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}