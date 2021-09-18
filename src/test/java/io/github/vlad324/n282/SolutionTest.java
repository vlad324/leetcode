package io.github.vlad324.n282;

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
            .add(arguments("0", 0, List.of("0")))
            .add(arguments("123", 6, List.of("1*2*3", "1+2+3")))
            .add(arguments("232", 8, List.of("2*3+2", "2+3*2")))
            .add(arguments("105", 5, List.of("1*0+5", "10-5")))
            .add(arguments("00", 0, List.of("0*0", "0+0", "0-0")))
            .add(arguments("3456237490", 9191, List.of()))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String num, int target, List<String> expected) {
        // when
        final var actual = solution.addOperators(num, target);

        // then
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

}