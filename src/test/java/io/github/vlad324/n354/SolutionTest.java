package io.github.vlad324.n354;

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
            .add(arguments(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}, 3))
            .add(arguments(new int[][]{{1, 1}, {1, 1}, {1, 1}}, 1))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[][] envelopes, int expected) {
        // when
        final var actual = solution.maxEnvelopes(envelopes);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}