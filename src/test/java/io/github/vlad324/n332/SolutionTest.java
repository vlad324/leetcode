package io.github.vlad324.n332;

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
            arguments(List.of(
                List.of("MUC", "LHR"),
                List.of("JFK", "MUC"),
                List.of("SFO", "SJC"),
                List.of("LHR", "SFO")
            ), List.of("JFK", "MUC", "LHR", "SFO", "SJC")),
            arguments(List.of(
                List.of("JFK", "SFO"),
                List.of("JFK", "ATL"),
                List.of("SFO", "ATL"),
                List.of("ATL", "JFK"),
                List.of("ATL", "SFO")
            ), List.of("JFK", "ATL", "JFK", "SFO", "ATL", "SFO")),
            arguments(List.of(
                List.of("JFK", "KUL"),
                List.of("JFK", "NRT"),
                List.of("NRT", "JFK")
            ), List.of("JFK", "NRT", "JFK", "KUL"))
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(List<List<String>> tickets, List<String> expected) {
        // when
        final var actual = solution.findItinerary(tickets);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}