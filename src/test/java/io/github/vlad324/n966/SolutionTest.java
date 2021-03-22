package io.github.vlad324.n966;

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
            .add(arguments(
                new String[]{"KiTe", "kite", "hare", "Hare"},
                new String[]{"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"},
                new String[]{"kite", "KiTe", "KiTe", "Hare", "hare", "", "", "KiTe", "", "KiTe"}))
            .add(arguments(
                new String[]{"wg", "uo", "as", "kv", "ra", "mw", "gi", "we", "og", "zu"},
                new String[]{"AS", "in", "yc", "kv", "mw", "ov", "lc", "os", "wm", "Mw"},
                new String[]{"as", "", "", "kv", "mw", "", "", "as", "", "mw"}))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String[] wordlist, String[] queries, String[] expected) {
        // when
        final var actual = solution.spellchecker(wordlist, queries);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}