package io.github.vlad324.n1189;

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
            .add(arguments("nlaebolko", 1))
            .add(arguments("loonbalxballpoon", 2))
            .add(arguments("leetcode", 0))
            .add(arguments("b", 0))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String text, int expected) {
        // when
        final var actual = solution.maxNumberOfBalloons(text);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}