package io.github.vlad324.n55;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    // [2,3,1,1,4]

    // i = 0, canJump(0+2) || canJump(0+1)
    // i = 1, canJump(1+3) || canJump(1+2) || canJump(1+1)

    private static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments(new int[]{2, 3, 1, 1, 4}, true))
            .add(arguments(new int[]{3, 2, 1, 0, 4}, false))
            .add(arguments(new int[]{0}, true))
            .add(arguments(new int[]{0, 2}, false))
            .add(arguments(new int[]{2, 0}, true))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] nums, boolean expected) {
        // when
        final var actual = solution.canJump(nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}