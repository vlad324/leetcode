package io.github.vlad324.n35;

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
            arguments(new int[]{1, 3, 5, 6}, 5, 2),
            arguments(new int[]{1, 3, 5, 6}, 2, 1),
            arguments(new int[]{1, 3, 5, 6}, 7, 4),
            arguments(new int[]{1, 3, 5, 6}, 0, 0),
            arguments(new int[]{}, 0, 0),
            arguments(new int[]{0}, 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] nums, int target, int expected) {
        // then
        assertThat(solution.searchInsert(nums, target)).isEqualTo(expected);
        assertThat(solution.searchInsert2(nums, target)).isEqualTo(expected);
    }
}