package io.github.vlad324.n52;

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
            .add(arguments(1, 1))
            .add(arguments(2, 0))
            .add(arguments(3, 0))
            .add(arguments(4, 2))
            .add(arguments(5, 10))
            .add(arguments(6, 4))
            .add(arguments(7, 40))
            .add(arguments(8, 92))
            .add(arguments(9, 352))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int n, int expected) {
        // when
        final var actual = solution.totalNQueens(n);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}