package io.github.vlad324.n1209;

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
            .add(arguments("abcd", 2, "abcd"))
            .add(arguments("deeedbbcccbdaa", 3, "aa"))
            .add(arguments("pbbcggttciiippooaais", 2, "ps"))
            .add(arguments("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy", 4, "ybth"))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String s, int k, String expected) {
        // when
        final var actual = solution.removeDuplicates(s, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}