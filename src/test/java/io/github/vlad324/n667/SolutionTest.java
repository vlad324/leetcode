package io.github.vlad324.n667;

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
            .add(arguments(3, 1, new int[]{1, 2, 3}))
            .add(arguments(3, 2, new int[]{1, 3, 2}))
            .add(arguments(4, 2, new int[]{1, 2, 4, 3}))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int n, int k, int[] expected) {
        // when
        final var actual = solution.constructArray(n, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}