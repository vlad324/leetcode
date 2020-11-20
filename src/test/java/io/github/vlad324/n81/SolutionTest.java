package io.github.vlad324.n81;

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
            .add(arguments(new int[]{2, 5, 6, 0, 0, 1, 2}, 0, true))
            .add(arguments(new int[]{2, 5, 6, 0, 0, 1, 2}, 3, false))
            .add(arguments(new int[]{1}, 1, true))
            .add(arguments(new int[]{1, 1}, 2, false))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] nums, int target, boolean expected) {
        // when
        final var actual = solution.search(nums, target);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}