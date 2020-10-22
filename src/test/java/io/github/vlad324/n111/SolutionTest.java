package io.github.vlad324.n111;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.n111.Solution.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
//            .add(arguments(null, 0))
            .add(arguments(new TreeNode(1), 1))
            .add(arguments(new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), null)), 2))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(TreeNode root, int expected) {
        // when
        final var actual = solution.minDepth(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}