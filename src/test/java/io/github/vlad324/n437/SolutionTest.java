package io.github.vlad324.n437;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.n437.Solution.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
            arguments(new TreeNode(10,
                new TreeNode(5,
                    new TreeNode(3,
                        new TreeNode(3),
                        new TreeNode(-2)
                    ),
                    new TreeNode(2,
                        null,
                        new TreeNode(1)
                    )
                ),
                new TreeNode(-3,
                    null,
                    new TreeNode(11)
                )
            ), 8, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(TreeNode root, int sum, int expected) {
        // when
        final var actual = solution.pathSum(root, sum);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}