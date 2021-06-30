package io.github.vlad324.n236;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.n236.Solution.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments(new TreeNode(1, new TreeNode(2), null), new TreeNode(1), new TreeNode(2), new TreeNode(1)))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(TreeNode root, TreeNode p, TreeNode q, TreeNode expected) {
        // when
        final var actual = solution.lowestCommonAncestor(root, p, q);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}