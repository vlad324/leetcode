package io.github.vlad324.n1015;

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
            .add(arguments(2, -1))
            .add(arguments(3, 3))
            .add(arguments(5, -1))
            .add(arguments(17, 16))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int k, int expected) {
        // when
        final var actual = solution.smallestRepunitDivByK(k);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}