package io.github.vlad324.n1551;

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
            .add(arguments(1, 0))
            .add(arguments(2, 1))
            .add(arguments(3, 2))
            .add(arguments(4, 4))
            .add(arguments(5, 6))
            .add(arguments(6, 9))
            .add(arguments(7, 12))
            .add(arguments(8, 16))
            .add(arguments(9, 20))
            .add(arguments(10, 25))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int n, int expected) {
        // when
        final var actual = solution.minOperations(n);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}