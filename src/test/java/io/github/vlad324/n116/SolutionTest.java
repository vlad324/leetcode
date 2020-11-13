package io.github.vlad324.n116;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.n116.Solution.Node;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        final var n7 = new Node(7);
        final var n6 = new Node(6, n7);
        final var n5 = new Node(5, n6);
        final var n4 = new Node(4, n5);
        final var n3 = new Node(3, n6, n7);
        final var n2 = new Node(2, n4, n5, n3);
        final var n1 = new Node(1, n2, n3);

        return Stream.<Arguments>builder()
            .add(arguments(
                new Node(1,
                    new Node(2,
                        new Node(4),
                        new Node(5)
                    ),
                    new Node(3,
                        new Node(6),
                        new Node(7)
                    )
                ),
                n1
            ))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(Node root, Node expected) {
        // when
        final var actual = solution.connect(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}