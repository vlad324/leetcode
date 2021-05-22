package io.github.vlad324.n890;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments(
                new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"},
                "abb",
                List.of("mee", "aqq")
            ))
            .add(arguments(
                new String[]{"a", "b", "c"},
                "a",
                List.of("a", "b", "c")
            ))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String[] words, String pattern, List<String> expected) {
        // when
        final var actual = solution.findAndReplacePattern(words, pattern);

        // then
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

}