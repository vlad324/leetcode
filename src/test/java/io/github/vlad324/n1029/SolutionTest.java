package io.github.vlad324.n1029;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {
    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
            arguments(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}}, 110),
            arguments(new int[][]{{10, 10}, {20, 20}, {30, 30}, {40, 40}}, 100),
            arguments(new int[][]{{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}}, 1859)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[][] costs, int expected) {
        // when
        final var actual = solution.twoCitySchedCost(costs);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}