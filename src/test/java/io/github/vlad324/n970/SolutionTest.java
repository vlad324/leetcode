package io.github.vlad324.n970;

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
            .add(arguments(2, 3, 10, List.of(2, 3, 4, 5, 7, 9, 10)))
            .add(arguments(3, 5, 15, List.of(2, 4, 6, 8, 10, 14)))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int x, int y, int bound, List<Integer> expected) {
        // when
        final var actual = solution.powerfulIntegers(x, y, bound);

        // then
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

}