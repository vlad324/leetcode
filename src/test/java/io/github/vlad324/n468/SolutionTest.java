package io.github.vlad324.n468;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
            arguments("172.16.254.1", "IPv4"),
            arguments("1.1.1.1", "IPv4"),
            arguments("1.1.-0.1", "Neither"),
            arguments("172.16.254.01", "Neither"),
            arguments("256.256.256.256", "Neither"),
            arguments("2001:0db8:85a3:0000:0000:8a2e:0370:7334", "IPv6"),
            arguments("2001:db8:85a3:0:0:8A2E:0370:7334", "IPv6"),
            arguments("2001:db8:85a3:0:0:FFFF:0370:7334", "IPv6"),
            arguments("2001:db8:85a3:0:0:GGGG:0370:7334", "Neither"),
            arguments("2001:0db8:85a3::8A2E:0370:7334", "Neither"),
            arguments("02001:0db8:85a3:0000:0000:8a2e:0370:7334", "Neither"),
            arguments("2001:0db8:85a3:0:0:8A2E:0370:7334:", "Neither"),
            arguments(":2001:0db8:85a3:0:0:8A2E:0370:7334", "Neither"),
            arguments("1081:db8:85a3:01:-0:8A2E:0370:7334", "Neither")
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String ip, String expected) {
        // when
        final var actual = solution.validIPAddress(ip);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}