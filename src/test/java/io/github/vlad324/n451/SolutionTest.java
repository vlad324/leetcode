package io.github.vlad324.n451;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
            arguments("tree", "eetr"),
            arguments("cccaaa", "cccaaa"),
            arguments("Aabb", "bbaA"),
            arguments("", ""),
            arguments("loveleetcode", "eeeeoollvtdc")
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String input, String expected) {
        // when
        final var actual = solution.frequencySort(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}