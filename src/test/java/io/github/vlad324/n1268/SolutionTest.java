package io.github.vlad324.n1268;

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
            .add(arguments(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse", List.of(
                List.of("mobile", "moneypot", "monitor"),
                List.of("mobile", "moneypot", "monitor"),
                List.of("mouse", "mousepad"),
                List.of("mouse", "mousepad"),
                List.of("mouse", "mousepad")
            )))
            .add(arguments(new String[]{"havana"}, "havana", List.of(
                List.of("havana"),
                List.of("havana"),
                List.of("havana"),
                List.of("havana"),
                List.of("havana"),
                List.of("havana")
            )))
            .add(arguments(new String[]{"havana"}, "tavana", List.of(
                List.of(),
                List.of(),
                List.of(),
                List.of(),
                List.of(),
                List.of()
            )))
            .add(arguments(new String[]{"bags", "baggage", "banner", "box", "cloths"}, "bags", List.of(
                List.of("baggage", "bags", "banner"),
                List.of("baggage", "bags", "banner"),
                List.of("baggage", "bags"),
                List.of("bags")
            )))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String[] products, String searchWord, List<List<String>> expected) {
        // when
        final var actual = solution.suggestedProducts(products, searchWord);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}