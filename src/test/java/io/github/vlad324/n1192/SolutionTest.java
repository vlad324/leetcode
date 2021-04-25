package io.github.vlad324.n1192;

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
            .add(arguments(
                4,
                List.of(
                    List.of(0, 1),
                    List.of(1, 2),
                    List.of(2, 0),
                    List.of(1, 3)
                ),
                List.of(
                    List.of(1, 3)
                )
            ))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int n, List<List<Integer>> connections, List<List<Integer>> expected) {
        // when
        final var actual = solution.criticalConnections(n, connections);

        // then
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }
}