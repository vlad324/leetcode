package io.github.vlad324.n593;

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
            .add(arguments(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 1}, true))
            .add(arguments(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 2}, false))
            .add(arguments(new int[]{0, 0}, new int[]{0, 0}, new int[]{0, 0}, new int[]{0, 0}, false))
            .add(arguments(
                new int[]{1134, -2539},
                new int[]{492, -1255},
                new int[]{-792, -1897},
                new int[]{-150, -3181},
                true))
            .add(arguments(
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{0, 2},
                new int[]{0, 0},
                false))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] p1, int[] p2, int[] p3, int[] p4, boolean expected) {
        // when
        final var actual = solution.validSquare(p1, p2, p3, p4);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}