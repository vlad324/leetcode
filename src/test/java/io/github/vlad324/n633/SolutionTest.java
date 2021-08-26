package io.github.vlad324.n633;

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
            .add(arguments(0, true))
            .add(arguments(1, true))
            .add(arguments(2, true))
            .add(arguments(3, false))
            .add(arguments(4, true))
            .add(arguments(5, true))
            .add(arguments(6, false))
            .add(arguments(7, false))
            .add(arguments(8, true))
            .add(arguments(9, true))
            .add(arguments(10, true))
            .add(arguments(11, false))
            .add(arguments(12, false))
            .add(arguments(13, true))
            .add(arguments(14, false))
            .add(arguments(15, false))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int c, boolean expected) {
        // when
        final var actual = solution.judgeSquareSum(c);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}