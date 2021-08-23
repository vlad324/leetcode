package io.github.vlad324.n653;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.n653.Solution.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments(
                new TreeNode(5,
                    new TreeNode(3,
                        new TreeNode(2),
                        new TreeNode(4)
                    ),
                    new TreeNode(6,
                        null,
                        new TreeNode(7)
                    )
                ),
                9,
                true
            ))
            .add(arguments(
                new TreeNode(5,
                    new TreeNode(3,
                        new TreeNode(2),
                        new TreeNode(4)
                    ),
                    new TreeNode(6,
                        null,
                        new TreeNode(7)
                    )
                ),
                28,
                false
            ))
            .add(arguments(
                new TreeNode(2,
                    new TreeNode(1),
                    new TreeNode(3)
                ),
                4,
                true
            ))
            .add(arguments(
                new TreeNode(2,
                    new TreeNode(1),
                    new TreeNode(3)
                ),
                1,
                false
            ))
            .add(arguments(
                new TreeNode(2,
                    new TreeNode(1),
                    new TreeNode(3)
                ),
                3,
                true
            ))
            .add(arguments(
                new TreeNode(1),
                2,
                false
            ))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(TreeNode root, int k, boolean expected) {
        // when
        final var actual = solution.findTarget(root, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}