package io.github.vlad324.n1217;

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
            .add(arguments(new int[]{1, 2, 3}, 1))
            .add(arguments(new int[]{2, 2, 2, 3, 3}, 2))
            .add(arguments(new int[]{1, 1000000000}, 1))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] position, int expected) {
        // when
        final var actual = solution.minCostToMoveChips(position);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}