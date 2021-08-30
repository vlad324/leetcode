package io.github.vlad324.n598;

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
            .add(arguments(3, 3, new int[][]{{2, 2}, {3, 3}}, 4))
            .add(arguments(3, 3, new int[][]{{2, 2}, {3, 3}, {3, 3}, {3, 3}, {2, 2}, {3, 3}, {3, 3},
                {3, 3}, {2, 2}, {3, 3}, {3, 3}, {3, 3}}, 4))
            .add(arguments(3, 3, new int[][]{}, 9))
            .add(arguments(1, 1, new int[][]{{1, 1}}, 1))
            .add(arguments(39999, 39999, new int[][]{{19999, 19999}}, 399960001))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int m, int n, int[][] ops, int expected) {
        // when
        final var actual = solution.maxCount(m, n, ops);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    //
    //

}