package io.github.vlad324.n1649;

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
            .add(arguments(new int[]{1, 5, 6, 2}, 1))
            .add(arguments(new int[]{1, 2, 3, 6, 5, 4}, 3))
            .add(arguments(new int[]{1, 3, 3, 3, 2, 4, 2, 1, 2}, 4))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] instructions, int expected) {
        // when
        final var actual = solution.createSortedArray(instructions);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}