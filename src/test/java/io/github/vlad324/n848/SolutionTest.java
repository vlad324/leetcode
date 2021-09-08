package io.github.vlad324.n848;

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
            .add(arguments("abc", new int[]{3, 5, 9}, "rpl"))
            .add(arguments("aaa", new int[]{1, 2, 3}, "gfd"))
            .add(arguments("zzz", new int[]{3, 5, 9}, "qni"))
            .add(arguments("gr", new int[]{5, 7}, "sy"))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String s, int[] shifts, String expected) {
        // when
        final var actual = solution.shiftingLetters(s, shifts);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}