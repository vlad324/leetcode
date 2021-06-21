package io.github.vlad324.n118;

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
            .add(arguments(5, List.of(
                List.of(1),
                List.of(1, 1),
                List.of(1, 2, 1),
                List.of(1, 3, 3, 1),
                List.of(1, 4, 6, 4, 1)
            )))
            .add(arguments(1, List.of(
                List.of(1)
            )))
            .add(arguments(2, List.of(
                List.of(1),
                List.of(1, 1)
            )))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int numRows, List<List<Integer>> expected) {
        // when
        final var actual = solution.generate(numRows);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}