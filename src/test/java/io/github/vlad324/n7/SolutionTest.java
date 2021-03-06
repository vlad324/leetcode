package io.github.vlad324.n7;

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
            arguments(0, 0),
            arguments(5, 5),
            arguments(123, 321),
            arguments(-123, -321),
            arguments(120, 21),
            arguments(Integer.MAX_VALUE, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int input, int expected) {
        // when
        final var actual = solution.reverse(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}