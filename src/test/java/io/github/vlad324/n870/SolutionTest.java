package io.github.vlad324.n870;

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
                new int[]{2, 7, 11, 15},
                new int[]{1, 10, 4, 11},
                new int[]{2, 11, 7, 15}))
            .add(arguments(
                new int[]{12, 24, 8, 32},
                new int[]{13, 25, 32, 11},
                new int[]{24, 32, 8, 12}))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] A, int[] B, int[] expected) {
        // when
        final var actual = solution.advantageCount(A, B);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}