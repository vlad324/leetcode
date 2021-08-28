package io.github.vlad324.n1235;

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
            .add(arguments(
                new int[]{1, 2, 3, 3},
                new int[]{3, 4, 5, 6},
                new int[]{50, 10, 40, 70},
                120
            ))
            .add(arguments(
                new int[]{1, 2, 3, 4, 6},
                new int[]{3, 5, 10, 6, 9},
                new int[]{20, 20, 100, 70, 60},
                150
            ))
            .add(arguments(
                new int[]{1, 1, 1},
                new int[]{2, 3, 4},
                new int[]{5, 6, 4},
                6
            ))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] startTime, int[] endTime, int[] profit, int expected) {
        // when
        final var actual = solution.jobScheduling(startTime, endTime, profit);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result_by_start_time(int[] startTime, int[] endTime, int[] profit, int expected) {
        // when
        final var actual = solution.jobSchedulingByStartTime(startTime, endTime, profit);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}