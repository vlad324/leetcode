package io.github.vlad324.n15;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments(new int[]{-1, 0, 1, 2, -1, -4}, List.of(List.of(-1, -1, 2), List.of(-1, 0, 1))))
            .add(arguments(new int[]{-1, 0, 1, 2, 2, -4}, List.of(List.of(-1, 0, 1), List.of(-4, 2, 2))))
            .add(arguments(new int[]{4, 0, 1, 3, 2, -4}, List.of(List.of(-4, 1, 3), List.of(-4, 0, 4))))
            .add(arguments(new int[]{}, List.of()))
            .add(arguments(new int[]{0}, List.of()))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] nums, List<List<Integer>> expected) {
        // when
        final var actual = solution.threeSum(nums);

        // then
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

}