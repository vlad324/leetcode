package io.github.vlad324.n134;

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
            .add(arguments(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}, 3))
            .add(arguments(new int[]{2, 3, 4}, new int[]{3, 4, 3}, -1))
            .add(arguments(new int[]{2}, new int[]{1}, 0))
            .add(arguments(new int[]{5, 1, 2, 3, 4}, new int[]{4, 4, 1, 5, 1}, 4))
            .add(arguments(new int[]{5, 5, 1, 3, 4}, new int[]{8, 1, 7, 1, 1}, 3))
            .build();
    }


    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] gas, int[] cost, int expected) {
        // when
        final var actual = solution.canCompleteCircuit(gas, cost);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}