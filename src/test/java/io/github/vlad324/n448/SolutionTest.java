package io.github.vlad324.n448;

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
            .add(arguments(new int[]{4, 3, 2, 7, 8, 2, 3, 1}, List.of(5, 6)))
            .add(arguments(new int[]{1, 1}, List.of(2)))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] nums, List<Integer> expected) {
        // when
        final var actual = solution.findDisappearedNumbers(nums);

        // then
        assertThat(actual).containsExactlyElementsOf(expected);
    }

}