package io.github.vlad324.n1480;

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
            .add(arguments(new int[]{1, 2, 3, 4}, new int[]{1, 3, 6, 10}))
            .add(arguments(new int[]{1, 1, 1, 1, 1}, new int[]{1, 2, 3, 4, 5}))
            .add(arguments(new int[]{3, 1, 2, 10, 1}, new int[]{3, 4, 6, 16, 17}))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] nums, int[] expected) {
        // when
        final var actual = solution.runningSum(nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}