package io.github.vlad324.n43;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();


    public static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments("2", "3", "6"))
            .add(arguments("123", "456", "56088"))
            .add(arguments("99", "9999", "989901"))
            .add(arguments("9999", "99", "989901"))
            .add(arguments("0", "99", "0"))
            .add(arguments("1", "99", "99"))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String num1, String num2, String expected) {
        // when
        final var actual = solution.multiply(num1, num2);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}