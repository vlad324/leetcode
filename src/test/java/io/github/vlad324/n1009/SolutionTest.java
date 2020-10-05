package io.github.vlad324.n1009;

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
            .add(arguments(1, 0))
            .add(arguments(5, 2))
            .add(arguments(7, 0))
            .add(arguments(10, 5))
            .add(arguments(0, 1))
            .add(arguments(3, 0))
            .add(arguments(4, 3))
            .add(arguments(1000000000, 73741823))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int N, int expected) {
        // when
        final var actual = solution.bitwiseComplement(N);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}