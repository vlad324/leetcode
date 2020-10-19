package io.github.vlad324.n1007;

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
            .add(arguments(
                new int[]{2, 1, 2, 4, 2, 2},
                new int[]{5, 2, 6, 2, 3, 2},
                2))
            .add(arguments(
                new int[]{3, 5, 1, 2, 3},
                new int[]{3, 6, 3, 3, 4},
                -1))
            .add(arguments(
                new int[]{2, 1},
                new int[]{1, 2},
                1))
            .add(arguments(
                new int[]{2, 2},
                new int[]{1, 1},
                0))
            .add(arguments(
                new int[]{2, 3, 2, 1, 1, 1, 2, 2},
                new int[]{2, 1, 2, 1, 1, 3, 1, 1},
                -1))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] A, int[] B, int expected) {
        // when
        final var actual = solution.minDominoRotations(A, B);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}