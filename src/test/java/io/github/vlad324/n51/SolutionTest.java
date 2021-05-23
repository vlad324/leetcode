package io.github.vlad324.n51;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments(1, List.of(List.of("Q"))))
            .add(arguments(2, List.of()))
            .add(arguments(3, List.of()))
            .add(arguments(4, List.of(
                List.of(".Q..", "...Q", "Q...", "..Q."),
                List.of("..Q.", "Q...", "...Q", ".Q.."))))
            .add(arguments(5, List.of(
                List.of("Q....", "..Q..", "....Q", ".Q...", "...Q."),
                List.of("Q....", "...Q.", ".Q...", "....Q", "..Q.."),
                List.of(".Q...", "...Q.", "Q....", "..Q..", "....Q"),
                List.of(".Q...", "....Q", "..Q..", "Q....", "...Q."),
                List.of("..Q..", "Q....", "...Q.", ".Q...", "....Q"),
                List.of("..Q..", "....Q", ".Q...", "...Q.", "Q...."),
                List.of("...Q.", "Q....", "..Q..", "....Q", ".Q..."),
                List.of("...Q.", ".Q...", "....Q", "..Q..", "Q...."),
                List.of("....Q", ".Q...", "...Q.", "Q....", "..Q.."),
                List.of("....Q", "..Q..", "Q....", "...Q.", ".Q..."))))
            .add(arguments(6, List.of(
                List.of(".Q....", "...Q..", ".....Q", "Q.....", "..Q...", "....Q."),
                List.of("..Q...", ".....Q", ".Q....", "....Q.", "Q.....", "...Q.."),
                List.of("...Q..", "Q.....", "....Q.", ".Q....", ".....Q", "..Q..."),
                List.of("....Q.", "..Q...", "Q.....", ".....Q", "...Q..", ".Q...."))))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int n, List<List<String>> expected) {
        // when
        final var actual = solution.solveNQueens(n);

        // then
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

}