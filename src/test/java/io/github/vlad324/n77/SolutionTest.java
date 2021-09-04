package io.github.vlad324.n77;

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
            .add(arguments(1, 1, List.of(
                List.of(1)
            )))
            .add(arguments(2, 1, List.of(
                List.of(1),
                List.of(2)
            )))
            .add(arguments(4, 2, List.of(
                List.of(2, 4),
                List.of(3, 4),
                List.of(2, 3),
                List.of(1, 2),
                List.of(1, 3),
                List.of(1, 4)
            )))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int n, int k, List<List<Integer>> expected) {
        // when
        final var actual = solution.combine(n, k);

        // then
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

}