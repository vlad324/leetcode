package io.github.vlad324.n509;

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
            .add(arguments(2, 1))
            .add(arguments(3, 2))
            .add(arguments(4, 3))
            .add(arguments(27, 196418))
            .add(arguments(28, 317811))
            .add(arguments(29, 514229))
            .add(arguments(30, 832040))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int n, int expected) {
        // when
        final var actual = solution.fib(n);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}