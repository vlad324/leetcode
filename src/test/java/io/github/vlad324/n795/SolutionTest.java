package io.github.vlad324.n795;

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
            .add(arguments(new int[]{2, 1, 4, 3}, 2, 3, 3))
            .add(arguments(new int[]{2, 1, 3, 4, 3}, 2, 3, 6))
            .add(arguments(new int[]{2, 3, 1, 4, 3}, 2, 3, 6))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] nums, int left, int right, int expected) {
        // when
        final var actual = solution.numSubarrayBoundedMax(nums, left, right);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}