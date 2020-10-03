package io.github.vlad324.n532;

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
            .add(arguments(new int[]{3, 1, 4, 1, 5}, 2, 2))
            .add(arguments(new int[]{1, 2, 3, 4, 5}, 1, 4))
            .add(arguments(new int[]{1, 2, 4, 4, 3, 3, 0, 9, 2, 3}, 3, 2))
            .add(arguments(new int[]{-1, -2, -3}, 1, 2))
            .add(arguments(new int[]{1, 3, 1, 5, 4}, 0, 1))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] nums, int k, int expected) {
        // when
        final var actual = solution.findPairs(nums, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}