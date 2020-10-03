package io.github.vlad324.n429;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.n429.Solution.Node;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
            arguments(null, Collections.emptyList()),
            arguments(new Node(1), List.of(List.of(1))),
            arguments(
                new Node(1, List.of(
                    new Node(3, List.of(
                        new Node(5), new Node(6)
                    )),
                    new Node(2),
                    new Node(4)
                )),
                List.of(
                    List.of(1),
                    List.of(3, 2, 4),
                    List.of(5, 6)
                )),
            arguments(
                new Node(1, List.of(
                    new Node(2),
                    new Node(3, List.of(
                        new Node(6),
                        new Node(7, List.of(
                            new Node(11, List.of(
                                new Node(14)
                            ))
                        ))
                    )),
                    new Node(4, List.of(
                        new Node(8, List.of(
                            new Node(12)
                        ))
                    )),
                    new Node(5, List.of(
                        new Node(9, List.of(
                            new Node(13)
                        )),
                        new Node(10)
                    ))
                )),
                List.of(
                    List.of(1),
                    List.of(2, 3, 4, 5),
                    List.of(6, 7, 8, 9, 10),
                    List.of(11, 12, 13),
                    List.of(14)
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(Node node, List<List<Integer>> expected) {
        // when
        final var actual = solution.levelOrder(node);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}