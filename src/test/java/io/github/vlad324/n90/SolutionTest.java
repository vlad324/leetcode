package io.github.vlad324.n90;

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
            .add(arguments(new int[]{1, 2, 2}, List.of(list(), list(1), list(2), list(1, 2), list(2, 2), list(1, 2, 2))))
            .add(arguments(new int[]{0}, List.of(list(), list(0))))
            .add(arguments(new int[]{0, 0}, List.of(list(), list(0), list(0, 0))))
            .add(arguments(new int[]{1, 2, 2, 3, 2}, List.of(list(), list(1), list(1, 2), list(1, 2, 2),
                list(1, 2, 2, 2), list(1, 2, 2, 2, 3), list(1, 2, 2, 3), list(1, 2, 3), list(1, 3),
                list(2), list(2, 2), list(2, 2, 2), list(2, 2, 2, 3), list(2, 2, 3), list(2, 3), list(3))))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] nums, List<List<Integer>> expected) {
        // when
        final var actual = solution.subsetsWithDup(nums);

        // then
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    private static List<Integer> list(Integer... values) {
        return List.of(values);
    }

}