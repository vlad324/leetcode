package io.github.vlad324.n125;

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
            arguments("A man, a plan, a canal: Panama", true),
            arguments("race a car", false),
            arguments("0P", false),
            arguments("P0", false),
            arguments("", true)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String s, boolean expected) {
        // when
        final var actual = solution.isPalindrome(s);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}