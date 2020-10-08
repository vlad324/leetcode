package io.github.vlad324.n704;

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
            .add(arguments(new int[]{-1, 0, 3, 5, 9, 12}, -1, 0))
            .add(arguments(new int[]{-1, 0, 3, 5, 9, 12}, 0, 1))
            .add(arguments(new int[]{-1, 0, 3, 5, 9, 12}, 3, 2))
            .add(arguments(new int[]{-1, 0, 3, 5, 9, 12}, 5, 3))
            .add(arguments(new int[]{-1, 0, 3, 5, 9, 12}, 9, 4))
            .add(arguments(new int[]{-1, 0, 3, 5, 9, 12}, 12, 5))
            .add(arguments(new int[]{-1, 0, 3, 5, 9, 12}, 2, -1))
            .add(arguments(new int[]{5}, 5, 0))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] nums, int target, int expected) {
        // when
        final var actual = solution.search(nums, target);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}