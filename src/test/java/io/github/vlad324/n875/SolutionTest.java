package io.github.vlad324.n875;

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
            .add(arguments(new int[]{1}, 8, 1))
            .add(arguments(new int[]{3, 6, 7, 11}, 8, 4))
            .add(arguments(new int[]{30, 11, 23, 4, 20}, 5, 30))
            .add(arguments(new int[]{30, 11, 23, 4, 20}, 6, 23))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] piles, int h, int expected) {
        // when
        final var actual = solution.minEatingSpeed(piles, h);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}