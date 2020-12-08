package io.github.vlad324.n1010;

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
            .add(arguments(new int[]{30, 20, 150, 100, 40}, 3))
            .add(arguments(new int[]{60, 60, 60}, 3))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] times, int expected) {
        // when
        final var actual = solution.numPairsDivisibleBy60(times);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}