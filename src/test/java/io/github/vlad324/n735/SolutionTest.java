package io.github.vlad324.n735;

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
            .add(arguments(new int[]{5, 10, -5}, new int[]{5, 10}))
            .add(arguments(new int[]{8, -8}, new int[]{}))
            .add(arguments(new int[]{10, 2, -5}, new int[]{10}))
            .add(arguments(new int[]{-2, -1, 1, 2}, new int[]{-2, -1, 1, 2}))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] asteroids, int[] expected) {
        // when
        final var actual = solution.asteroidCollision(asteroids);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}