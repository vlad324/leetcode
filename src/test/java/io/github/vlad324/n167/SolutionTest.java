package io.github.vlad324.n167;

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
            .add(arguments(new int[]{2, 7, 11, 15}, 9, new int[]{1, 2}))
            .add(arguments(new int[]{2, 3, 4}, 6, new int[]{1, 3}))
            .add(arguments(new int[]{-1, 0}, -1, new int[]{1, 2}))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] numbers, int target, int[] expected) {
        // when
        final var actual = solution.twoSum(numbers, target);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}