package io.github.vlad324.n878;

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
            .add(arguments(1, 2, 3, 2))
            .add(arguments(4, 2, 3, 6))
            .add(arguments(5, 5, 4, 12))
            .add(arguments(3, 6, 4, 8))
            .add(arguments(2, 2, 2, 4))
            .add(arguments(1000, 5, 8, 3335))
            .add(arguments(557796, 35883, 22601, 735033994))
            .add(arguments(1000000000, 40000, 40000, 999720007))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int n, int a, int b, int expected) {
        // when
        final var actual = solution.nthMagicalNumber(n, a, b);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}