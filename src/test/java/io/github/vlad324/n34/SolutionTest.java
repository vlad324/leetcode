package io.github.vlad324.n34;

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
            .add(arguments(new int[]{5, 7, 7, 8, 8, 8, 10}, 8, new int[]{3, 5}))
            .add(arguments(new int[]{5, 7, 7, 8, 8, 8, 10}, 5, new int[]{0, 0}))
            .add(arguments(new int[]{5, 7, 7, 8, 8, 8, 10, 10}, 10, new int[]{6, 7}))
            .add(arguments(new int[]{5, 7, 7, 8, 8, 10}, 6, new int[]{-1, -1}))
            .add(arguments(new int[]{}, 0, new int[]{-1, -1}))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] nums, int target, int[] expected) {
        // when
        final var actual = solution.searchRange(nums, target);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}