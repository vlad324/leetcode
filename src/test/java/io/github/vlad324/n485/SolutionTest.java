package io.github.vlad324.n485;

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
            arguments(new int[]{1, 1, 0, 1, 1, 1}, 3),
            arguments(new int[]{}, 0),
            arguments(new int[]{0}, 0),
            arguments(new int[]{1}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] nums, int expected) {
        // when
        final var actual = solution.findMaxConsecutiveOnes(nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}