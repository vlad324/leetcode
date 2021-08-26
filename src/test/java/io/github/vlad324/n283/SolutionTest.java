package io.github.vlad324.n283;

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
            .add(arguments(new int[]{0, 1, 0, 3, 12}, new int[]{1, 3, 12, 0, 0}))
            .add(arguments(new int[]{0, 1, 0}, new int[]{1, 0, 0}))
            .add(arguments(new int[]{0}, new int[]{0}))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] nums, int[] expected) {
        // when
        solution.moveZeroes(nums);

        // then
        assertThat(nums).isEqualTo(expected);
    }

}