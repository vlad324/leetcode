package io.github.vlad324.n187;

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
            .add(arguments("AAAAAAAAAAAAA", List.of("AAAAAAAAAA")))
            .add(arguments("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", List.of("AAAAACCCCC", "CCCCCAAAAA")))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String s, List<String> expected) {
        // when
        final var actual = solution.findRepeatedDnaSequences(s);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}