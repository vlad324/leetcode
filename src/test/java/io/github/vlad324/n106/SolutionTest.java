package io.github.vlad324.n106;

import static io.github.vlad324.common.TreeNode.treeNode;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3},
                treeNode(3,
                    treeNode(9),
                    treeNode(20,
                        treeNode(15),
                        treeNode(7)
                    )
                )
            ))
            .add(arguments(new int[]{-1}, new int[]{-1}, treeNode(-1)))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] inorder, int[] postorder, TreeNode expected) {
        // when
        final var actual = solution.buildTree(inorder, postorder);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}