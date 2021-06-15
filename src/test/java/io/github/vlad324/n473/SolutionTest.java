package io.github.vlad324.n473;

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
            .add(arguments(new int[]{1, 1, 2, 2, 2}, true))
            .add(arguments(new int[]{1, 1, 1, 1}, true))
            .add(arguments(new int[]{3, 3, 3, 3, 4}, false))
            .add(arguments(new int[]{4}, false))
            .add(arguments(new int[]{0, 0, 0, 0}, false))
            .add(arguments(new int[]{6, 6, 6, 6, 4, 2, 2}, false))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] matchsticks, boolean expected) {
        // when
        final var actual = solution.makesquare(matchsticks);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}