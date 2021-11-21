package io.github.vlad324.n209;

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
            .add(arguments(7, new int[]{2, 3, 1, 2, 4, 3}, 2))
            .add(arguments(4, new int[]{1, 4, 4}, 1))
            .add(arguments(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}, 0))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int target, int[] nums, int expected) {
        // when
        final var actual = solution.minSubArrayLen(target, nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}