package io.github.vlad324.n316;

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
            .add(arguments("bcabc", "abc"))
            .add(arguments("cbacdcbc", "acdb"))
            .add(arguments("cbacdcabcd", "abcd"))
            .add(arguments("abacb", "abc"))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String s, String expected) {
        // when
        final var actual = solution.removeDuplicateLetters(s);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}