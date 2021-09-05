package io.github.vlad324.n899;

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
            .add(arguments("cba", 1, "acb"))
            .add(arguments("baaca", 3, "aaabc"))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String s, int k, String expected) {
        // when
        final var actual = solution.orderlyQueue(s, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}