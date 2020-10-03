package io.github.vlad324.n1460;

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
            arguments(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3}, true),
            arguments(new int[]{7}, new int[]{7}, true),
            arguments(new int[]{12, 1}, new int[]{1, 12}, true),
            arguments(new int[]{3, 7, 9}, new int[]{3, 7, 11}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] a, int[] b, boolean expected) {
        // when
        final var actual = solution.canBeEqual(a, b);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}