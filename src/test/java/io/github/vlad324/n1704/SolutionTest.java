package io.github.vlad324.n1704;

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
            .add(arguments("book", true))
            .add(arguments("textbook", false))
            .add(arguments("MerryChristmas", false))
            .add(arguments("AbCdEfGh", true))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String s, boolean expected) {
        // when
        final var actual = solution.halvesAreAlike(s);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}