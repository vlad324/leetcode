package io.github.vlad324.n109;

import static io.github.vlad324.common.CollectionUtils.linkedList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.common.ListNode;
import io.github.vlad324.n109.Solution.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments(
                linkedList(-10, -3, 0, 5, 9),
                new TreeNode(0,
                    new TreeNode(-3,
                        new TreeNode(-10),
                        null
                    ),
                    new TreeNode(9,
                        new TreeNode(5),
                        null
                    )
                )
            ))
            .add(arguments(null, null))
            .add(arguments(linkedList(0), new TreeNode(0)))
            .add(arguments(linkedList(1, 3), new TreeNode(3, new TreeNode(1), null)))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(ListNode head, TreeNode expected) {
        // when
        final var actual = solution.sortedListToBST(head);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}