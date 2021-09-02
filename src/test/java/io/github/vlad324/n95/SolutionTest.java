package io.github.vlad324.n95;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.n95.Solution.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments(1, List.of(new TreeNode(1))))
            .add(arguments(2, List.of(
                new TreeNode(1, null, new TreeNode(2)),
                new TreeNode(2, new TreeNode(1), null)
            )))
            .add(arguments(3, List.of(
                new TreeNode(1, null, new TreeNode(3, new TreeNode(2), null)),
                new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3))),
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(3, new TreeNode(2, new TreeNode(1), null), null),
                new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), null)
            )))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int n, List<TreeNode> expected) {
        // when
        final var actual = solution.generateTrees(n);

        // then
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

}