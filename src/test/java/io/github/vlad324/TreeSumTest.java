package io.github.vlad324;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class TreeSumTest {

    private final TreeSum treeSum = new TreeSum();

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
            arguments(new int[]{-1, 0, 1, 2, -1, -4},
                new List[]{List.of(-1, 0, 1), List.of(-1, -1, 2)}),
            arguments(new int[]{-1, -1, 0, 1, 1, 2, -1, -4},
                new List[]{List.of(-1, 0, 1), List.of(-1, -1, 2)}),
            arguments(new int[]{0, 0, 0, 0},
                new List[]{List.of(0, 0, 0)})
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] input, List<Integer>[] expected) {
        // when
        final var actual = treeSum.threeSum(input);

        // then
        assertThat(actual).containsExactlyInAnyOrder(expected);
    }
}