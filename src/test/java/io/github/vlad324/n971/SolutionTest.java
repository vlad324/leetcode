package io.github.vlad324.n971;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.n971.Solution.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments(
                new TreeNode(1, new TreeNode(2), null),
                new int[]{2, 1},
                List.of(-1)
            ))
            .add(arguments(
                new TreeNode(1, new TreeNode(2), new TreeNode(3)),
                new int[]{1, 3, 2},
                List.of(1)
            ))
            .add(arguments(
                new TreeNode(1, new TreeNode(2), new TreeNode(3)),
                new int[]{1, 2, 3},
                List.of()
            ))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(TreeNode root, int[] voyage, List<Integer> expected) {
        // when
        final var actual = solution.flipMatchVoyage(root, voyage);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}