package io.github.vlad324.n188n;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments(2, new int[]{2, 4, 1}, 2))
            .add(arguments(2, new int[]{3, 2, 6, 5, 0, 3}, 7))
            .add(arguments(0, new int[]{3, 2, 6, 5, 0, 3}, 0))
            .add(arguments(10, new int[]{}, 0))
            .build();
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int k, int[] prices, int expected) {
        // when
        final var actual = solution.maxProfit(k, prices);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}