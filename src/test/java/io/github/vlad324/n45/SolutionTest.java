package io.github.vlad324.n45;

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
            .add(arguments(new int[]{1}, 0))
            .add(arguments(new int[]{2, 1}, 1))
            .add(arguments(new int[]{2, 3, 1, 1, 4}, 2))
            .add(arguments(new int[]{2, 3, 0, 1, 4}, 2))
            .add(arguments(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}, 3))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] nums, int expected) {
        // when
        final var actual = solution.jump(nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}