package io.github.vlad324.n1302;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.n1302.Solution.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments(new TreeNode(1,
                new TreeNode(2,
                    new TreeNode(4,
                        new TreeNode(7),
                        null),
                    new TreeNode(5)
                ),
                new TreeNode(3,
                    null,
                    new TreeNode(6,
                        null,
                        new TreeNode(8)))
            ), 15))
            .add(arguments(new TreeNode(6,
                new TreeNode(7,
                    new TreeNode(2,
                        new TreeNode(9),
                        null),
                    new TreeNode(7,
                        new TreeNode(1),
                        new TreeNode(4))
                ),
                new TreeNode(8,
                    new TreeNode(1),
                    new TreeNode(3,
                        null,
                        new TreeNode(5)))
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