package io.github.vlad324.n162;

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
            .add(arguments(new int[]{1, 2, 3, 1}, 2))
            .add(arguments(new int[]{4, 2, 3, 1}, 2))
            .add(arguments(new int[]{4, 3, 2, 1}, 0))
            .add(arguments(new int[]{1, 2, 3, 4}, 3))
            .add(arguments(new int[]{1, 2, 3, 4, 5}, 4))
            .add(arguments(new int[]{5, 4, 3, 2, 1}, 0))
            .add(arguments(new int[]{3, 4, 5, 2, 1}, 2))
            .add(arguments(new int[]{1, 2, 1, 3, 5, 6, 4}, 5))
            .add(arguments(new int[]{1}, 0))
            .add(arguments(new int[]{1, 2}, 1))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] nums, int expected) {
        // when
        final var actual = solution.findPeakElement(nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}