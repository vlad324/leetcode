package io.github.vlad324.n474;

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
            .add(arguments(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3, 4))
            .add(arguments(new String[]{"10", "0", "1"}, 1, 1, 2))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String[] strs, int m, int n, int expected) {
        // when
        final var actual = solution.findMaxForm(strs, m, n);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}