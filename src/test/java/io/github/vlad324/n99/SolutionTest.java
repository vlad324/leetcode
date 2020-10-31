package io.github.vlad324.n99;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.n99.Solution.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments(
                new TreeNode(1,
                    new TreeNode(3,
                        null,
                        new TreeNode(2)
                    ),
                    null
                ),
                new TreeNode(3,
                    new TreeNode(1,
                        null,
                        new TreeNode(2)
                    ),
                    null
                )
            ))
            .add(arguments(
                new TreeNode(2,
                    new TreeNode(3),
                    new TreeNode(1)
                ),
                new TreeNode(2,
                    new TreeNode(1),
                    new TreeNode(3)
                )
            ))
            .add(arguments(
                new TreeNode(3,
                    new TreeNode(1),
                    new TreeNode(4,
                        new TreeNode(2),
                        null
                    )
                ),
                new TreeNode(2,
                    new TreeNode(1),
                    new TreeNode(4,
                        new TreeNode(3),
                        null
                    )
                )
            ))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(TreeNode root, TreeNode expected) {
        // when
        solution.recoverTree(root);

        // then
        assertThat(root).isEqualTo(expected);
    }
}