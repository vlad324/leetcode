package io.github.vlad324.n239;

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
            .add(arguments(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3, new int[]{3, 3, 5, 5, 6, 7}))
            .add(arguments(new int[]{1}, 1, new int[]{1}))
            .add(arguments(new int[]{1, -1}, 1, new int[]{1, -1}))
            .add(arguments(new int[]{9, 11}, 2, new int[]{11}))
            .add(arguments(new int[]{4, -2}, 2, new int[]{4}))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] nums, int k, int[] expected) {
        // when
        final var actual = solution.maxSlidingWindow(nums, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}