package io.github.vlad324.n450;

import static io.github.vlad324.common.CollectionUtils.tree;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments(tree(5, 3, 6, 2, 4, null, 7), 3, tree(5, 4, 6, 2, null, null, 7)))
            .add(arguments(tree(5, 3, 8, 2, 4, 6, 9), 5, tree(6, 3, 8, 2, 4, null, 9)))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(TreeNode root, int key, TreeNode expected) {
        // when
        final var actual = solution.deleteNode(root, key);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}