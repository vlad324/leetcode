package io.github.vlad324.n528;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.stream.Stream;

class SolutionTest {

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
//            arguments(new int[]{1}, 1),
            arguments(new int[]{1, 2, 3, 4}, 5),
            arguments(new int[]{0, 0, 0, 1}, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] weights, int times) {
        // given
        final var solution = new Solution(weights);

        // when
        final var list = new LinkedList<Integer>();
        for (int i = 0; i < times; i++) {
            list.add(solution.pickIndex());
        }


        // then
        assertThat(list).hasSize(times);
        assertThat(list).allMatch(i -> i >= 0 && i < weights.length);
    }

}