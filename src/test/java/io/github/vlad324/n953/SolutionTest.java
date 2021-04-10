package io.github.vlad324.n953;

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
            .add(arguments(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz", true))
            .add(arguments(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz", false))
            .add(arguments(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz", false))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String[] words, String order, boolean expected) {
        // when
        final var actual = solution.isAlienSorted(words, order);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}