package io.github.vlad324.n200;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource({"testDataProvider"})
    void should_return_excepted_result(char[][] grid, int exceptedCount) {
        // when
        final var actualCount = solution.numIslands(grid);

        // then
        assertThat(actualCount).isEqualTo(exceptedCount);
    }

    private static Stream<Arguments> testDataProvider() {
        final var data1 = List.of(
            "11110",
            "11010",
            "11000",
            "00000"
        );

        final var data2 = List.of(
            "11000",
            "11000",
            "00100",
            "00011"
        );

        final var data3 = List.of(
            "1"
        );

        final var data4 = List.of(
            "0"
        );

        return Stream.of(
            arguments(toGrid(data1), 1),
            arguments(toGrid(data2), 3),
            arguments(toGrid(data3), 1),
            arguments(toGrid(data4), 0),
            arguments(new char[0][0], 0)
        );
    }

    private static char[][] toGrid(List<String> data) {
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Invalid input data");
        }

        final int firstLineLength = data.get(0).length();
        final var grid = new char[data.size()][firstLineLength];
        for (int i = 0; i < grid.length; i++) {
            final var line = data.get(i);

            if (line.length() != firstLineLength) {
                throw new IllegalArgumentException("Line has unexpected length");
            }

            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        return grid;
    }
}