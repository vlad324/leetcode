package io.github.vlad324;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class SummaryRangesTest {

    private final SummaryRanges summaryRanges = new SummaryRanges();

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
            arguments(new int[]{0, 1, 2, 4, 5, 7}, List.of("0->2", "4->5", "7")),
            arguments(new int[]{0, 2, 3, 4, 6, 8, 9}, List.of("0", "2->4", "6", "8->9")),
            arguments(new int[]{0}, List.of("0")),
            arguments(new int[0], Collections.emptyList())
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] input, List<String> expected) {
        // when
        final var actual = summaryRanges.summaryRanges(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}