package io.github.vlad324.n1302;

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
            .add(arguments(treeNode(1,
                treeNode(2,
                    treeNode(4,
                        treeNode(7),
                        null),
                    treeNode(5)
                ),
                treeNode(3,
                    null,
                    treeNode(6,
                        null,
                        treeNode(8)))
            ), 15))
            .add(arguments(treeNode(6,
                treeNode(7,
                    treeNode(2,
                        treeNode(9),
                        null),
                    treeNode(7,
                        treeNode(1),
                        treeNode(4))
                ),
                treeNode(8,
                    treeNode(1),
                    treeNode(3,
                        null,
                        treeNode(5)))
            ), 19))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(TreeNode root, int expected) {
        // when
        final var actual = solution.deepestLeavesSum(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}