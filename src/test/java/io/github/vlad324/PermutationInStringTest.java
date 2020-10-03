package io.github.vlad324;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PermutationInStringTest {

    private final PermutationInString permutation = new PermutationInString();

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
            arguments("ab", "eidbaooo", true),
            arguments("ab", "eidboaoo", false)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_excepted_result(String s1, String s2, boolean expected) {
        // when
        final var actual = permutation.checkInclusion(s1, s2);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}