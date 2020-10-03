package io.github.vlad324.n191;

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
            arguments(0b00000000000000000000000000001011, 3),
            arguments(0b00000000000000000000000010000000, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int n, int expected) {
        // when
        final var actual = solution.hammingWeight(n);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}