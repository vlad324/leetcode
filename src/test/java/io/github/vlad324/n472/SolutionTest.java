package io.github.vlad324.n472;

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
            .add(arguments(new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog",
                "hippopotamuses", "rat", "ratcatdogcat"}, List.of("catsdogcats", "dogcatsdog", "ratcatdogcat")))
            .add(arguments(new String[]{"a", "aa", "t", "at"}, List.of("aa", "at")))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String[] words, List<String> expected) {
        // when
        final var actual = solution.findAllConcatenatedWordsInADict(words);

        // then
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

}