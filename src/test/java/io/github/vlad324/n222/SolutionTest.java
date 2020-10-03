package io.github.vlad324.n222;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.n222.Solution.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
            arguments(new TreeNode(1,
                new TreeNode(2,
                    new TreeNode(4),
                    new TreeNode(5)
                ),
                new TreeNode(3,
                    new TreeNode(6),
                    null
                )
            ), 6),
            arguments(new TreeNode(1,
                new TreeNode(2,
                    new TreeNode(4),
                    new TreeNode(5)
                ),
                new TreeNode(3,
                    null,
                    null
                )
            ), 5),
            arguments(new TreeNode(1,
                new TreeNode(2,
                    new TreeNode(4),
                    null
                ),
                new TreeNode(3,
                    null,
                    null
                )
            ), 4),
            arguments(new TreeNode(1), 1),
            arguments(new TreeNode(1,
                new TreeNode(2),
                null
            ), 2)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(TreeNode root, int expected) {
        // when
        final var actual = solution.countNodes(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}