package io.github.vlad324.n98;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.n98.Solution.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {
    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
            arguments(null, true),
            arguments(new TreeNode(2), true),
            arguments(new TreeNode(2,
                new TreeNode(1),
                new TreeNode(3)), true),
            arguments(new TreeNode(5,
                new TreeNode(1),
                new TreeNode(6,
                    new TreeNode(4),
                    new TreeNode(3)
                )), false),
            // 10,5,15,null,null,6,20
            arguments(new TreeNode(10,
                new TreeNode(5),
                new TreeNode(15,
                    new TreeNode(6),
                    new TreeNode(20)
                )), false)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(TreeNode root, boolean expected) {
        // when
        final var actual = solution.isValidBST(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}