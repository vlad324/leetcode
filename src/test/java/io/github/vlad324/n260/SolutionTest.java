package io.github.vlad324.n260;

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
            arguments(new int[]{1, 2, 1, 3, 2, 5}, new int[]{3, 5}),
            arguments(new int[]{3, 5}, new int[]{3, 5}),
            arguments(new int[]{3, 5, 6, 6}, new int[]{3, 5})
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] nums, int[] expected) {
        // when
        final var actual = solution.singleNumber(nums);

        // then
        assertThat(actual).containsExactlyInAnyOrder(expected);
    }
}