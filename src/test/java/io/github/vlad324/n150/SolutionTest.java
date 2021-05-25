package io.github.vlad324.n150;

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
            .add(arguments(new String[]{"0"}, 0))
            .add(arguments(new String[]{"4", "3", "-"}, 1))
            .add(arguments(new String[]{"2", "1", "+", "3", "*"}, 9))
            .add(arguments(new String[]{"4", "13", "5", "/", "+"}, 6))
            .add(arguments(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}, 22))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String[] tokens, int expected) {
        // when
        final var actual = solution.evalRPN(tokens);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}