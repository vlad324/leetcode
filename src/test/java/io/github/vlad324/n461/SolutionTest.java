package io.github.vlad324.n461;

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
            arguments(1, 4, 2),
            arguments(0, 0, 0),
            arguments(11, 11, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int x, int y, int expected) {
        // when
        final var actual = solution.hammingDistance(x, y);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}