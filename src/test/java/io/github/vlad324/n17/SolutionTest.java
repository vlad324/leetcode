package io.github.vlad324.n17;

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
            .add(arguments("23", List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")))
            .add(arguments("", List.of()))
            .add(arguments("2", List.of("a", "b", "c")))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String digits, List<String> expected) {
        // when
        final var actual = solution.letterCombinations(digits);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}