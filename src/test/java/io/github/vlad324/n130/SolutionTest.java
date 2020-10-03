package io.github.vlad324.n130;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
            arguments(new char[][]{
                    {'X', 'X', 'X', 'X'},
                    {'X', 'O', 'O', 'X'},
                    {'X', 'X', 'O', 'X'},
                    {'X', 'O', 'X', 'X'}
                },
                new char[][]{
                    {'X', 'X', 'X', 'X'},
                    {'X', 'X', 'X', 'X'},
                    {'X', 'X', 'X', 'X'},
                    {'X', 'O', 'X', 'X'}
                }),
            arguments(new char[][]{
                    {'X', 'X', 'X', 'X'},
                    {'X', 'O', 'O', 'X'},
                    {'X', 'O', 'O', 'X'},
                    {'X', 'O', 'X', 'X'}
                },
                new char[][]{
                    {'X', 'X', 'X', 'X'},
                    {'X', 'O', 'O', 'X'},
                    {'X', 'O', 'O', 'X'},
                    {'X', 'O', 'X', 'X'}
                }),
            arguments(new char[][]{
                    {'O'}
                },
                new char[][]{
                    {'O'}
                }),
            arguments(new char[][]{
                    {'X'}
                },
                new char[][]{
                    {'X'}
                }),
            arguments(new char[][]{
                    {'X', 'O', 'X'},
                    {'O', 'X', 'O'},
                    {'X', 'O', 'X'}
                },
                new char[][]{
                    {'X', 'O', 'X'},
                    {'O', 'X', 'O'},
                    {'X', 'O', 'X'}
                }),
            arguments(new char[][]{
                    {'X', 'O', 'X', 'O', 'X', 'O'},
                    {'O', 'X', 'O', 'X', 'O', 'X'},
                    {'X', 'O', 'X', 'O', 'X', 'O'},
                    {'O', 'X', 'O', 'X', 'O', 'X'}
                },
                new char[][]{
                    {'X', 'O', 'X', 'O', 'X', 'O'},
                    {'O', 'X', 'X', 'X', 'X', 'X'},
                    {'X', 'X', 'X', 'X', 'X', 'O'},
                    {'O', 'X', 'O', 'X', 'O', 'X'}
                })
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(char[][] board, char[][] expected) {
        // when
        solution.solve(board);

        // then
        assertThat(board).isEqualTo(expected);
    }

}