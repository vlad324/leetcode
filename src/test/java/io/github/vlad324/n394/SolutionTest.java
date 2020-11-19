package io.github.vlad324.n394;

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
            .add(arguments("3[a]2[bc]", "aaabcbc"))
            .add(arguments("3[a2[c]]", "accaccacc"))
            .add(arguments("2[abc]3[cd]ef", "abcabccdcdcdef"))
            .add(arguments("abc3[cd]xyz", "abccdcdcdxyz"))
            .add(arguments("10[leetcode]", "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode"))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String s, String expected) {
        // when
        final var actual = solution.decodeString(s);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}