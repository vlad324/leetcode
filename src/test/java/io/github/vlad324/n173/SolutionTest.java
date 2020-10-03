package io.github.vlad324.n173;

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
            arguments(new int[]{2, 2, 3, 2}, 3),
            arguments(new int[]{2, 2, 3, 2, 4, 4, 4}, 3),
            arguments(new int[]{0, 1, 0, 1, 0, 1, 99}, 99)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] nums, int expected) {
        // when
        final var actual = solution.singleNumber(nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}