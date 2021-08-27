package io.github.vlad324.n557;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    public static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments("Let's take LeetCode contest", "s'teL ekat edoCteeL tsetnoc"))
            .add(arguments("God Ding", "doG gniD"))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String s, String expected) {
        // when
        final var actual = solution.reverseWords(s);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}