package io.github.vlad324.n563;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.n563.Solution.TreeNode;
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
                    new TreeNode(2),
                    new TreeNode(3)
                ), 1)
            )
            .add(arguments(
                new TreeNode(4,
                    new TreeNode(2,
                        new TreeNode(3),
                        new TreeNode(5)
                    ),
                    new TreeNode(9,
                        null,
                        new TreeNode(7)
                    )
                ), 15)
            )
            .add(arguments(
                new TreeNode(21,
                    new TreeNode(7,
                        new TreeNode(1,
                            new TreeNode(3),
                            new TreeNode(3)
                        ),
                        new TreeNode(1)
                    ),
                    new TreeNode(14,
                        new TreeNode(2),
                        new TreeNode(2)
                    )
                ), 9)
            )
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(TreeNode root, int expected) {
        // when
        final var actual = solution.findTilt(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}