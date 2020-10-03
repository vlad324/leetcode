package io.github.vlad324;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

class SmallestElementTest {

    private final SmallestElement smallestElement = new SmallestElement();

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_return_expected_result(SmallestElement.TreeNode root, int k, int expectedValue) {
        // when
        final var actualValue = smallestElement.kthSmallest(root, k);

        // then
        assertThat(actualValue).isEqualTo(expectedValue);
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
//            arguments(tree(new Integer[]{3, 1, 4, null, 2}), 1, 1),
            arguments(tree(new Integer[]{5, 3, 6, 2, 4, null, null, 1}), 3, 3)
        );
    }

    private static SmallestElement.TreeNode tree(Integer[] integers) {
        final var root = new SmallestElement.TreeNode(integers[0]);
        Queue<SmallestElement.TreeNode> toProcess = new LinkedList<>();
        toProcess.add(root);
        for (int i = 1; i < integers.length; i++) {
            final var node = toProcess.poll();

            if (node == null) {
                throw new IllegalStateException("Nothing to process");
            }

            if (integers[i] != null) {
                final var left = new SmallestElement.TreeNode(integers[i]);
                toProcess.add(left);
                node.left = left;
            }

            if (++i < integers.length && integers[i] != null) {
                final var right = new SmallestElement.TreeNode(integers[i]);
                toProcess.add(right);
                node.right = right;
            }
        }

        return root;
    }
}