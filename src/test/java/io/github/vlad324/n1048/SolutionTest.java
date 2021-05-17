package io.github.vlad324.n1048;

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
            .add(arguments(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}, 4))
            .add(arguments(new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"}, 5))
            .add(arguments(new String[]{"a", "b", "ab", "bac"}, 2))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String[] words, int expected) {
        // when
        final var actual = solution.longestStrChain(words);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}