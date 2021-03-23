package io.github.vlad324.n923;

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
            .add(arguments(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8, 20))
            .add(arguments(new int[]{1, 1, 2, 2, 2, 2}, 5, 12))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] arr, int target, int expected) {
        // when
        final var actual = solution.threeSumMulti(arr, target);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}