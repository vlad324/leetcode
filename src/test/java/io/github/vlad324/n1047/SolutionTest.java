package io.github.vlad324.n1047;

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
            .add(arguments("abbaca", "ca"))
            .add(arguments("abbacaa", "c"))
            .add(arguments("azxxzy", "ay"))
            .add(arguments("abbbaca", "abaca"))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String s, String expected) {
        // when
        final var actual = solution.removeDuplicates(s);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}