package io.github.vlad324.n229;

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
        return Stream.of(
            arguments(new int[]{3, 2, 3}, List.of(3)),
            arguments(new int[]{1, 1, 1, 3, 3, 2, 2, 2}, List.of(1, 2)),
            arguments(new int[]{1, 2}, List.of(1, 2)),
            arguments(new int[]{6, 6, 6, 7, 7}, List.of(6, 7))
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] nums, List<Integer> expected) {
        // when
        final var actual = solution.majorityElement(nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}