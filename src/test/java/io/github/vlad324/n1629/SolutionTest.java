package io.github.vlad324.n1629;

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
            .add(arguments(new int[]{9, 29, 49, 50}, "cbcd", 'c'))
            .add(arguments(new int[]{12, 23, 36, 46, 62}, "spuda", 'a'))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] releaseTimes, String keysPressed, char expected) {
        // when
        final var actual = solution.slowestKey(releaseTimes, keysPressed);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}