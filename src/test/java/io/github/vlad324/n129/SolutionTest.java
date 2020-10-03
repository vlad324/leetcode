package io.github.vlad324.n129;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.n129.Solution.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
            arguments(new TreeNode(1), 1),
            arguments(new TreeNode(1,
                new TreeNode(0),
                null
            ), 10),
            arguments(new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3)
            ), 25),
            arguments(new TreeNode(4,
                new TreeNode(9,
                    new TreeNode(5),
                    new TreeNode(1)
                ),
                new TreeNode(0)
            ), 1026),
            arguments(new TreeNode(4,
                new TreeNode(9,
                    new TreeNode(0),
                    null
                ),
                new TreeNode(1)
            ), 531)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(TreeNode a, int expected) {
        // when
        final var actual = solution.sumNumbers(a);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}