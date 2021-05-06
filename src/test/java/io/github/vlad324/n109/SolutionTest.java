package io.github.vlad324.n109;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.n109.Solution.ListNode;
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
                new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9))))),
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
            .add(arguments(new ListNode(0), new TreeNode(0)))
            .add(arguments(new ListNode(1, new ListNode(3)), new TreeNode(3, new TreeNode(1), null)))
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