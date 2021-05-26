package io.github.vlad324.n1689;

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
            .add(arguments("32", 3))
            .add(arguments("82734", 8))
            .add(arguments("27346209830709182346", 9))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String n, int expected) {
        // when
        final var actual = solution.minPartitions(n);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}