package io.github.vlad324.n720;

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
            arguments(new String[]{"w", "wo", "wor", "worl", "world"}, "world"),
            arguments(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}, "apple"),
            arguments(new String[]{"ogz", "eyj", "e", "ey", "hmn", "v", "hm", "ogznkb", "ogzn", "hmnm",
                "eyjuo", "vuq", "ogznk", "og", "eyjuoi", "d"}, "eyj"),
            arguments(new String[]{"yo", "ew", "fc", "zrc", "yodn", "fcm", "qm", "qmo",
                "fcmz", "z", "ewq", "yod", "ewqz", "y"}, "yodn")
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String[] words, String expected) {
        // when
        final var actual = solution.longestWord(words);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}