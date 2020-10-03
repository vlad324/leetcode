package io.github.vlad324;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ContiguousArrayTest {

    private final ContiguousArray contiguousArray = new ContiguousArray();

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
            arguments(new int[]{0, 1}, 2),
            arguments(new int[]{0, 1, 0}, 2),
            arguments(new int[]{0, 1, 1, 1}, 2),
            arguments(new int[]{0, 1, 0, 1}, 4),
            arguments(new int[]{1, 1, 1}, 0),
            arguments(new int[0], 0),
            arguments(new int[]{0, 0, 0, 1, 1, 1, 0}, 6),
            arguments(new int[]{1, 0, 0, 1, 1, 1}, 4),
            arguments(new int[]{1, 0, 0, 0, 1, 1, 1, 0}, 8),
            arguments(new int[]{0, 0, 1, 0, 0, 0, 1, 1}, 6),
            arguments(new int[]{0, 1, 1, 0, 1, 1, 1, 0}, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] nums, int expected) {
        // when
        final var actual = contiguousArray.findMaxLength(nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}