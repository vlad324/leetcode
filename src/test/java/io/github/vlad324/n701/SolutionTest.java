package io.github.vlad324.n701;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.n701.Solution.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments(
                new TreeNode(4,
                    new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)
                    ),
                    new TreeNode(7)
                ),
                5,
                new TreeNode(4,
                    new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)
                    ),
                    new TreeNode(7,
                        new TreeNode(5),
                        null
                    )
                )
            ))
            .add(arguments(
                new TreeNode(40,
                    new TreeNode(20,
                        new TreeNode(10),
                        new TreeNode(30)
                    ),
                    new TreeNode(60,
                        new TreeNode(50),
                        new TreeNode(70)
                    )
                ),
                25,
                new TreeNode(40,
                    new TreeNode(20,
                        new TreeNode(10),
                        new TreeNode(30,
                            new TreeNode(25),
                            null
                        )
                    ),
                    new TreeNode(60,
                        new TreeNode(50),
                        new TreeNode(70)
                    )
                )
            ))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(TreeNode root, int value, TreeNode expected) {
        // when
        final var actual = solution.insertIntoBST(root, value);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}