package io.github.vlad324.n33;

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
            .add(arguments(new int[]{4, 5, 6, 7, 8, 0, 1, 2}, 4, 0))
            .add(arguments(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4))
            .add(arguments(new int[]{4, 5, 6, 7, 0, 1, 2}, 2, 6))
            .add(arguments(new int[]{4, 5, 6, 7, 0, 1, 2}, 4, 0))
            .add(arguments(new int[]{4, 5, 6, 7, 0, 1, 2}, 7, 3))
            .add(arguments(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1))
            .add(arguments(new int[]{1}, 0, -1))
            .add(arguments(new int[]{1}, 1, 0))
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