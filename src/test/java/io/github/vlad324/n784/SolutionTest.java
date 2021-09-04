package io.github.vlad324.n784;

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
            .add(arguments("a1b2", List.of("a1b2", "a1B2", "A1b2", "A1B2")))
            .add(arguments("3z4", List.of("3z4", "3Z4")))
            .add(arguments("12345", List.of("12345")))
            .add(arguments("0", List.of("0")))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String s, List<String> expected) {
        // when
        final var actual = solution.letterCasePermutation(s);

        // then
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

}