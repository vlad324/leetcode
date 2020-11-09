package io.github.vlad324.n1026;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.n1026.Solution.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments(
                new TreeNode(8,
                    new TreeNode(3,
                        new TreeNode(1),
                        new TreeNode(6,
                            new TreeNode(4),
                            new TreeNode(7)
                        )
                    ),
                    new TreeNode(10,
                        null,
                        new TreeNode(14,
                            new TreeNode(13),
                            null
                        )
                    )
                ), 7))
            .add(arguments(
                new TreeNode(1,
                    null,
                    new TreeNode(2,
                        null,
                        new TreeNode(0,
                            new TreeNode(3),
                            null
                        )
                    )
                ), 3))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(TreeNode root, int expected) {
        // when
        final var actual = solution.maxAncestorDiff(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}