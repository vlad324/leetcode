package io.github.vlad324.n338;

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
//            arguments(2, new int[]{0, 1, 1}),
            arguments(5, new int[]{0, 1, 1, 2, 1, 2})
//            arguments(31, new int[]{0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5}),
//            arguments(0, new int[]{0})
        );

        // 0,      0
        // 1,      1

        // 1,      2
        // 2,      3

        // 1,      4
        // 2,      5
        // 2,      6
        // 3,      7

        // 1,      8
        // 2,      9
        // 2,      10
        // 3,      11
        // 2,      12
        // 3,      13
        // 3,      14
        // 4,      15

        // 1,      16
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int number, int[] expected) {
        // when
        final var actual = solution.countBits(number);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}