package io.github.vlad324;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class UncrossedLinesTest {

    private final UncrossedLines uncrossedLines = new UncrossedLines();

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
            arguments(new int[]{1, 4, 2}, new int[]{1, 2, 4}, 2),
            arguments(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}, 3),
            arguments(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1}, 2),
            arguments(new int[]{1}, new int[]{2}, 0),
            arguments(new int[]{2, 1}, new int[]{1, 2, 1, 3, 3, 2}, 2),
            arguments(new int[]{3, 3, 3, 1}, new int[]{2, 2, 3, 3}, 2),
            arguments(new int[]{3, 1, 2, 1, 4, 1, 2, 2, 5, 3, 2, 1, 1, 4, 5, 2, 3, 2, 5, 5},
                new int[]{2, 4, 1, 2, 3, 4, 2, 4, 5, 5, 1, 1, 2, 1, 1, 1, 5, 4, 1, 4, 2, 1, 5, 4, 2, 3, 1, 5, 2, 1}, 14)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] a, int[] b, int expected) {
        // when
        final var actual = uncrossedLines.maxUncrossedLines(a, b);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}