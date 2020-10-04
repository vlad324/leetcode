package io.github.vlad324.n1606;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments(
                3,
                new int[]{1, 2, 3, 4, 5},
                new int[]{5, 2, 3, 3, 3},
                List.of(1)
            ))
            .add(arguments(
                3,
                new int[]{1, 2, 3, 4},
                new int[]{1, 2, 1, 2},
                List.of(0)
            ))
            .add(arguments(
                3,
                new int[]{1, 2, 3},
                new int[]{10, 12, 11},
                List.of(0, 1, 2)
            ))
            .add(arguments(
                3,
                new int[]{1, 2, 3, 4, 8, 9, 10},
                new int[]{5, 2, 10, 3, 1, 2, 2},
                List.of(1)
            ))
            .add(arguments(
                1,
                new int[]{1},
                new int[]{1},
                List.of(0)
            ))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    @ArgumentsSource(TestDataProvider.class)
    void should_produce_expected_result(int k, int[] arrival, int[] load, List<Integer> expected) {
        // when
        final var actual = solution.busiestServers(k, arrival, load);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}