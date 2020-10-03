package io.github.vlad324.n957;

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
            arguments(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 7, new int[]{0, 0, 1, 1, 0, 0, 0, 0}),
            arguments(new int[]{1, 0, 0, 1, 0, 0, 1, 0}, 1000000000, new int[]{0, 0, 1, 1, 1, 1, 1, 0}),
            arguments(new int[]{0, 0, 0, 1, 1, 0, 1, 0}, 574, new int[]{0, 0, 0, 1, 1, 0, 1, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] cells, int days, int[] expected) {
        // when
        final var actual = solution.prisonAfterNDays(cells, days);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}