package io.github.vlad324.n537;

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
            .add(arguments("1+1i", "1+1i", "0+2i"))
            .add(arguments("1+-1i", "1+-1i", "0+-2i"))
            .add(arguments("5+-2i", "4+3i", "26+7i"))
            .add(arguments("5+2i", "4+-3i", "26+-7i"))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String num1, String num2, String expected) {
        // when
        final var actual = solution.complexNumberMultiply(num1, num2);
        final var actual2 = solution.complexNumberMultiply2(num1, num2);

        // then
        assertThat(actual).isEqualTo(expected);
        assertThat(actual2).isEqualTo(expected);
    }

}