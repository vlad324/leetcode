package io.github.vlad324.n456;

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
            .add(arguments(new int[]{1, 2, 3, 4}, false))
            .add(arguments(new int[]{3, 1, 4, 2}, true))
            .add(arguments(new int[]{-1, 3, 2, 0}, true))
            .add(arguments(new int[]{1, 0, 1, -4, -3}, false))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] nums, boolean expected) {
        // when
        final var actual = solution.find132pattern(nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}