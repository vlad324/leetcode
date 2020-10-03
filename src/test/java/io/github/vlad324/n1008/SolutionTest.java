package io.github.vlad324.n1008;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.n1008.Solution.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
            arguments(new int[]{8, 5, 1, 7, 10, 12},
                new TreeNode(8,
                    new TreeNode(5,
                        new TreeNode(1),
                        new TreeNode(7)),
                    new TreeNode(10,
                        null,
                        new TreeNode(12)))),
            arguments(new int[]{8},
                new TreeNode(8)),
            arguments(new int[]{8, 10},
                new TreeNode(8,
                    null,
                    new TreeNode(10)))
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] preoder, TreeNode expected) {
        // when
        final var actual = solution.bstFromPreorder(preoder);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}