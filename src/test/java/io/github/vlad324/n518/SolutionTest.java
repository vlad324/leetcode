package io.github.vlad324.n518;

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
            arguments(5, new int[]{1, 2, 5}, 4),
            arguments(5, new int[]{2, 1, 5}, 4),
            arguments(6, new int[]{1, 2, 5}, 5),
            arguments(3, new int[]{2}, 0),
            arguments(10, new int[]{10}, 1),
            arguments(0, new int[]{}, 1),
            arguments(500, new int[]{1, 2, 5}, 12701)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int amount, int[] coins, int expected) {
        // when
        final var actual = solution.change(amount, coins);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}