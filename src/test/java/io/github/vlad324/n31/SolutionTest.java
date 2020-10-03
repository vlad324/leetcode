package io.github.vlad324.n31;

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
            arguments(new int[]{1, 2, 3}, new int[]{1, 3, 2}),
            arguments(new int[]{1, 3, 2}, new int[]{2, 1, 3}),
            arguments(new int[]{3, 2, 1}, new int[]{1, 2, 3}),
            arguments(new int[]{2, 3, 1}, new int[]{3, 1, 2}),
            arguments(new int[]{1, 1, 5}, new int[]{1, 5, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] nums, int[] expected) {
        // when
        solution.nextPermutation(nums);

        // then
        assertThat(nums).isEqualTo(expected);
    }
}