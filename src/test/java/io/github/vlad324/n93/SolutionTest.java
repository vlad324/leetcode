package io.github.vlad324.n93;

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
        return Stream.of(
            arguments("25525511135", List.of(
                "255.255.11.135",
                "255.255.111.35"
            )),
            arguments("255255255255", List.of(
                "255.255.255.255"
            )),
            arguments("1111", List.of(
                "1.1.1.1"
            )),
            arguments("11111", List.of(
                "1.1.1.11",
                "1.1.11.1",
                "1.11.1.1",
                "11.1.1.1"
            )),
            arguments("111111", List.of(
                "1.1.1.111",
                "1.1.11.11",
                "1.1.111.1",
                "1.11.1.11",
                "1.11.11.1",
                "1.111.1.1",
                "11.1.1.11",
                "11.1.11.1",
                "11.11.1.1",
                "111.1.1.1"
            ))
        );

        // 1.1.1.1
        // 1.1.1.2
        // 1.1.1.3
        // 1.1.2.1
        // 1.1.3.1
        // 1.2.1.1
        // 1.3.1.1
        // 2.1.1.1
        // 3.1.1.1
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String s, List<String> expected) {
        // when
        final var actual = solution.restoreIpAddresses(s);

        // then
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }
}