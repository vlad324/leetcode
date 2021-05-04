package io.github.vlad324.n665;

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
            .add(arguments(new int[]{4, 2, 3}, true))
            .add(arguments(new int[]{1, 2, 3}, true))
            .add(arguments(new int[]{4, 2, 2}, true))
            .add(arguments(new int[]{5, 7, 1, 8}, true))
            .add(arguments(new int[]{4, 2, 1}, false))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] nums, boolean expected) {
        // when
        final var actual = solution.checkPossibility(nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}