package io.github.vlad324.n799;

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
            .add(arguments(1, 1, 1, 0.0))
            .add(arguments(2, 1, 0, 0.5))
            .add(arguments(2, 1, 1, 0.5))
            .add(arguments(3, 1, 1, 1.0))

            .add(arguments(4, 0, 0, 1.0))
            .add(arguments(4, 1, 0, 1.0))
            .add(arguments(4, 1, 1, 1.0))
            .add(arguments(4, 2, 0, 0.25))
            .add(arguments(4, 2, 1, 0.5))
            .add(arguments(4, 2, 2, 0.25))

            .add(arguments(5, 0, 0, 1.0))
            .add(arguments(5, 1, 0, 1.0))
            .add(arguments(5, 1, 1, 1.0))
            .add(arguments(5, 2, 0, 0.5))
            .add(arguments(5, 2, 1, 1.0))
            .add(arguments(5, 2, 2, 0.5))

            .add(arguments(6, 0, 0, 1.0))
            .add(arguments(6, 1, 0, 1.0))
            .add(arguments(6, 1, 1, 1.0))
            .add(arguments(6, 2, 0, 0.75))
            .add(arguments(6, 2, 1, 1.0))
            .add(arguments(6, 2, 2, 0.75))
            .add(arguments(6, 3, 0, 0.0))
            .add(arguments(6, 3, 1, 0.25))
            .add(arguments(6, 3, 2, 0.25))
            .add(arguments(6, 3, 3, 0.0))

            .add(arguments(25, 6, 1, 0.18750))
            .add(arguments(100000009, 33, 17, 1.0))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int poured, int query_row, int query_glass, double expected) {
        // when
        final var actual = solution.champagneTower(poured, query_row, query_glass);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}