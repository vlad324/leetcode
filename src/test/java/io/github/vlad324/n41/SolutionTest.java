package io.github.vlad324.n41;

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
            .add(arguments(new int[]{1, 2, 0}, 3))
            .add(arguments(new int[]{3, 4, -1, 1}, 2))
            .add(arguments(new int[]{7, 8, 9, 11, 12}, 1))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] nums, int expected) {
        // when
        final var actual = solution.firstMissingPositive(nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}