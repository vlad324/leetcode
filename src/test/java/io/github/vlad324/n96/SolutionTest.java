package io.github.vlad324.n96;

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
            arguments(1, 1),
            arguments(2, 2),
            arguments(3, 5),
            arguments(4, 14),
            arguments(5, 42),
            arguments(6, 132)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int n, int expected) {
        // when
        final var actual = solution.numTrees(n);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}