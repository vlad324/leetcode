package io.github.vlad324.n987;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.n987.Solution.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
            arguments(new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                    new TreeNode(15),
                    new TreeNode(7)
                )
            ), List.of(
                List.of(9),
                List.of(3, 15),
                List.of(20),
                List.of(7)
            )),
            arguments(new TreeNode(1,
                new TreeNode(2,
                    new TreeNode(4),
                    new TreeNode(5)
                ),
                new TreeNode(3,
                    new TreeNode(6),
                    new TreeNode(7)
                )
            ), List.of(
                List.of(4),
                List.of(2),
                List.of(1, 5, 6),
                List.of(3),
                List.of(7)
            ))
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(TreeNode root, List<List<Integer>> expected) {
        // when
        final var actual = solution.verticalTraversal(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}