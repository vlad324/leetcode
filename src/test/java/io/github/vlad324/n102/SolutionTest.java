package io.github.vlad324.n102;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.n102.Solution.TreeNode;
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
                new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))),
                List.of(List.of(3), List.of(9, 20), List.of(15, 7))
            ))
            .add(arguments(
                new TreeNode(1),
                List.of(List.of(1))
            ))
            .add(arguments(
                null,
                List.of()
            ))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(TreeNode root, List<List<Integer>> expected) {
        // when
        final var actual = solution.levelOrder(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}