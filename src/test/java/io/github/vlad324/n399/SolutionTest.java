package io.github.vlad324.n399;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Offset.offset;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments(
                List.of(List.of("a", "b"), List.of("b", "c")),
                new double[]{2.0, 3.0},
                List.of(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x")),
                new double[]{6.0, 0.5, -1.0, 1.0, -1.0}
            ))
            .add(arguments(
                List.of(List.of("a", "b"), List.of("b", "c"), List.of("bc", "cd")),
                new double[]{1.5, 2.5, 5.0},
                List.of(List.of("a", "c"), List.of("c", "b"), List.of("bc", "cd"), List.of("cd", "bc")),
                new double[]{3.75, 0.4, 5.0, 0.2}
            ))
            .add(arguments(
                List.of(List.of("a", "b")),
                new double[]{0.5},
                List.of(List.of("a", "b"), List.of("b", "a"), List.of("a", "c"), List.of("x", "y")),
                new double[]{0.5, 2.0, -1.0, -1.0}
            ))
            .add(arguments(
                List.of(List.of("x1", "x2"), List.of("x2", "x3"), List.of("x3", "x4"), List.of("x4", "x5")),
                new double[]{3.0, 4.0, 5.0, 6.0},
                List.of(List.of("x1", "x5"), List.of("x5", "x2"), List.of("x2", "x4"), List.of("x2", "x2"), List.of("x2", "x9")),
                new double[]{360.0, 0.00833, 20.0, 1.0, -1.0}
            ))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(List<List<String>> equations,
                                        double[] values,
                                        List<List<String>> queries,
                                        double[] expected) {
        // when
        final var actual = solution.calcEquation(equations, values, queries);

        // then
        assertThat(actual).containsExactly(expected, offset(0.00001d));
    }

}