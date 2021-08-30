package io.github.vlad324.n567;

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
            .add(arguments("ab", "eidbaooo", true))
            .add(arguments("ab", "eidoooba", true))
            .add(arguments("ab", "baeidooo", true))
            .add(arguments("ab", "eidboaoo", false))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String s1, String s2, boolean expected) {
        // when
        final var actual = solution.checkInclusion(s1, s2);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}