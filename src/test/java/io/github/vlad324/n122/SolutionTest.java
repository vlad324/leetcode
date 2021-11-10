package io.github.vlad324.n122;

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
            .add(arguments(new int[]{7, 1, 5, 3, 6, 4}, 7))
            .add(arguments(new int[]{1, 2, 3, 4, 5}, 4))
            .add(arguments(new int[]{7, 6, 4, 3, 1}, 0))
            .build();
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