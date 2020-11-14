package io.github.vlad324.n1652;

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
            .add(arguments(new int[]{5, 7, 1, 4}, 3, new int[]{12, 10, 16, 13}))
            .add(arguments(new int[]{1, 2, 3, 4}, 0, new int[]{0, 0, 0, 0}))
            .add(arguments(new int[]{2, 4, 9, 3}, -2, new int[]{12, 5, 6, 13}))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] nums, int k, int[] expected) {
        // when
        final var actual = solution.decrypt(nums, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}