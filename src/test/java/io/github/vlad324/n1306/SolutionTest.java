package io.github.vlad324.n1306;

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
            .add(arguments(new int[]{4, 2, 3, 0, 3, 1, 2}, 5, true))
            .add(arguments(new int[]{4, 2, 3, 0, 3, 1, 2}, 0, true))
            .add(arguments(new int[]{3, 0, 2, 1, 2}, 2, false))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] arr, int start, boolean expected) {
        // when
        final var actual = solution.canReach(arr, start);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}