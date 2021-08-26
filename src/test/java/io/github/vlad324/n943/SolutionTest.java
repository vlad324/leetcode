package io.github.vlad324.n943;

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
            .add(arguments(new String[]{"alex", "loves", "leetcode"}, "alexlovesleetcode"))
            .add(arguments(new String[]{"catg", "ctaagt", "gcta", "ttca", "atgcatc"}, "gctaagttcatgcatc"))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String[] words, String expected) {
        // when
        final var actual = solution.shortestSuperstring(words);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}