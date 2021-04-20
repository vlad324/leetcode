package io.github.vlad324.n589;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.n589.Solution.Node;
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
                new Node(1,
                    List.of(
                        new Node(3,
                            List.of(
                                new Node(5),
                                new Node(6)
                            )
                        ),
                        new Node(2),
                        new Node(4)
                    )
                ),
                List.of(1, 3, 5, 6, 2, 4)
            ))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(Node root, List<Integer> expected) {
        // when
        final var actual = solution.preorder(root);
        final var actualSequential = solution.preorderSequential(root);

        // then
        assertThat(actual).isEqualTo(expected);
        assertThat(actualSequential).isEqualTo(expected);
    }

}