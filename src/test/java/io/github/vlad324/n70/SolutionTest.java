package io.github.vlad324.n70;

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
            .add(arguments(1, 1))
            .add(arguments(2, 2))
            .add(arguments(3, 3))
            .add(arguments(4, 5))
            .add(arguments(5, 8))
            .add(arguments(6, 13))
            .add(arguments(7, 21))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int n, int expected) {
        // when
        final var actual = solution.climbStairs(n);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}