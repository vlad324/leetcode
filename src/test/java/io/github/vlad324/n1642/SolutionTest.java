package io.github.vlad324.n1642;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments(new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1, 4))
            .add(arguments(new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2, 7))
            .add(arguments(new int[]{14, 3, 19, 3}, 17, 0, 3))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] heights, int bricks, int ladders, int expected) {
        // when
        final var actual = solution.furthestBuilding(heights, bricks, ladders);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}