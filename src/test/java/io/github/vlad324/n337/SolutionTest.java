package io.github.vlad324.n337;

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
            .add(arguments(tree(3, 2, 3, null, 3, null, 1), 7))
            .add(arguments(tree(3, 4, 5, 1, 3, null, 1), 9))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(TreeNode node, int expected) {
        // when
        final var actual = solution.rob(node);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}