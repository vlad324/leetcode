package io.github.vlad324.n1695;

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
            .add(arguments(new int[]{4, 2, 4, 5, 6}, 17))
            .add(arguments(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5}, 8))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] nums, int expected) {
        // when
        final var actual = solution.maximumUniqueSubarray(nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}