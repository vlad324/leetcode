package io.github.vlad324.n764;

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
            .add(arguments(5, new int[][]{{4, 2}}, 2))
            .add(arguments(1, new int[][]{{0, 0}}, 0))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int n, int[][] mines, int expected) {
        // when
        final var actual = solution.orderOfLargestPlusSign(n, mines);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}