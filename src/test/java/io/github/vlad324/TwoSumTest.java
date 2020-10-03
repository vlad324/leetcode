package io.github.vlad324;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TwoSumTest {

    private final TwoSum twoSum = new TwoSum();

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
            arguments(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
            arguments(new int[]{2, 5, 5, 11}, 10, new int[]{1, 2}),
            arguments(new int[]{0, 4, 3, 0}, 0, new int[]{0, 3}),
            arguments(new int[]{3, 2, 4}, 6, new int[]{1, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] input, int target, int[] expected) {
        // when
        final var actual = twoSum.twoSum(input, target);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}