package io.github.vlad324.n309;

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
            arguments(new int[]{1, 2, 3, 0, 2}, 3),
            arguments(new int[]{1}, 0),
            arguments(new int[]{1, 2}, 1),
            arguments(new int[]{2, 1}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] prices, int expected) {
        // when
        final var actual = solution.maxProfit(prices);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}