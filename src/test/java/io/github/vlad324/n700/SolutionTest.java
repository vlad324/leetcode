package io.github.vlad324.n700;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.n700.Solution.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
            arguments(new TreeNode(2,
                    new TreeNode(1),
                    new TreeNode(3)),
                5, null),
            arguments(new TreeNode(4,
                    new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                    new TreeNode(7)),
                2, new TreeNode(2,
                    new TreeNode(1),
                    new TreeNode(3)))
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(TreeNode root, int value, TreeNode expected) {
        // when
        final var actual = solution.searchBST(root, value);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}