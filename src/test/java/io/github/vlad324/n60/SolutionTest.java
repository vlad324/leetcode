package io.github.vlad324.n60;

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
            arguments(3, 3, "213"),
            arguments(4, 9, "2314"),
            arguments(1, 1, "1"),
            arguments(9, 362880, "987654321"),
            arguments(3, 2, "132")
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int n, int k, String expected) {
        // when
        final var actual = solution.getPermutation(n, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}