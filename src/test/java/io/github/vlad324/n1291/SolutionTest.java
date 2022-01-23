package io.github.vlad324.n1291;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments(100, 300, List.of(123, 234)))
            .add(arguments(1000, 13000, List.of(1234, 2345, 3456, 4567, 5678, 6789, 12345)))
            .add(arguments(123456789, 1000000000, List.of(123456789)))
            .add(arguments(1000000000, 1000000000, List.of()))
            .add(arguments(10, 20, List.of(12)))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int low, int high, List<Integer> expected) {
        // when
        final var actual = solution.sequentialDigits(low, high);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}