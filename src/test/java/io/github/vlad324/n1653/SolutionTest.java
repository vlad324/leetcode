package io.github.vlad324.n1653;

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
            .add(arguments("aababbab", 2))
            .add(arguments("bbaaaaabb", 2))
            .add(arguments("aaaaabb", 0))
            .add(arguments("aaa", 0))
            .add(arguments("bbb", 0))
            .add(arguments("aabbbbaabababbbbaaaaaabbababaaabaabaabbbabbbbabbabbababaabaababbbbaaaaabbabbabaaaabbba" +
                "baaaabbaaabbbaabbaaaaabaa", 52))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String s, int expected) {
        // when
        final var actual = solution.minimumDeletions(s);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}