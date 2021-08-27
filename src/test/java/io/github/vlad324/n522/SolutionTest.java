package io.github.vlad324.n522;

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
            .add(arguments(new String[]{"aba", "cdc", "eae"}, 3))
            .add(arguments(new String[]{"aaa", "aaa", "aa"}, -1))
            .add(arguments(new String[]{"aaa", "aaa", "aaaa"}, 4))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String[] strs, int expected) {
        // when
        final var actual = solution.findLUSlength(strs);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}