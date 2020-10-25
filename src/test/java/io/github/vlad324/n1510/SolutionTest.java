package io.github.vlad324.n1510;

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
            .add(arguments(1, true))
            .add(arguments(2, false))
            .add(arguments(3, true))
            .add(arguments(3, true))
            .add(arguments(7, false))
            .add(arguments(17, false))
            .add(arguments(100000, true))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int n, boolean expected) {
        // when
        final var actual = solution.winnerSquareGame(n);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}