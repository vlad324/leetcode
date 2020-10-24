package io.github.vlad324.n948;

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
            .add(arguments(new int[]{100}, 50, 0))
            .add(arguments(new int[]{100, 200}, 100, 1))
            .add(arguments(new int[]{100, 200, 200}, 100, 1))
            .add(arguments(new int[]{100, 200, 300, 400}, 200, 2))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] tokens, int P, int expected) {
        // when
        final var actual = solution.bagOfTokensScore(tokens, P);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}