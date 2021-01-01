package io.github.vlad324.n1640;

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
            .add(arguments(new int[]{91, 4, 64, 78}, new int[][]{{78}, {4, 64}, {91}}, true))
            .add(arguments(new int[]{49, 18, 16}, new int[][]{{16, 18, 49}}, false))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] arr, int[][] pieces, boolean expected) {
        // when
        final var actual = solution.canFormArray(arr, pieces);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}