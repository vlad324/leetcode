package io.github.vlad324.n120;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments(
                List.of(
                    list(2),
                    list(3, 4),
                    list(6, 5, 7),
                    list(4, 1, 8, 3)
                ),
                11
            ))
            .add(arguments(List.of(list(-10)), -10))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(List<List<Integer>> triangle, int expected) {
        // when
        final var actual = solution.minimumTotal(triangle);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private static <T> List<T> list(T... values) {
        return new ArrayList<>(Arrays.asList(values));
    }
}