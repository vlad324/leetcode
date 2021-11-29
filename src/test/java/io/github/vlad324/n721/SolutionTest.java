package io.github.vlad324.n721;

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
            .add(arguments(
                List.of(
                    List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                    List.of("John", "johnsmith@mail.com", "john00@mail.com"),
                    List.of("Mary", "mary@mail.com"),
                    List.of("John", "johnnybravo@mail.com")),
                List.of(
                    List.of("John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"),
                    List.of("Mary", "mary@mail.com"),
                    List.of("John", "johnnybravo@mail.com"))))
            .add(arguments(
                List.of(
                    List.of("Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe1@m.co"),
                    List.of("Kevin", "Kevin3@m.co", "Kevin5@m.co", "Kevin0@m.co"),
                    List.of("Ethan", "Ethan5@m.co", "Ethan4@m.co", "Ethan0@m.co"),
                    List.of("Hanzo", "Hanzo3@m.co", "Hanzo1@m.co", "Hanzo0@m.co"),
                    List.of("Fern", "Fern5@m.co", "Fern1@m.co", "Fern0@m.co")),
                List.of(
                    List.of("Ethan", "Ethan0@m.co", "Ethan4@m.co", "Ethan5@m.co"),
                    List.of("Gabe", "Gabe0@m.co", "Gabe1@m.co", "Gabe3@m.co"),
                    List.of("Hanzo", "Hanzo0@m.co", "Hanzo1@m.co", "Hanzo3@m.co"),
                    List.of("Kevin", "Kevin0@m.co", "Kevin3@m.co", "Kevin5@m.co"),
                    List.of("Fern", "Fern0@m.co", "Fern1@m.co", "Fern5@m.co"))))
            .add(arguments(
                List.of(
                    List.of("John", "johnsmith0@mail.com", "johnsmith1@mail.com"),
                    List.of("John", "johnsmith2@mail.com", "johnsmith3@mail.com"),
                    List.of("John", "johnsmith1@mail.com", "johnsmith2@mail.com")),
                List.of(List.of("John", "johnsmith0@mail.com", "johnsmith1@mail.com", "johnsmith2@mail.com", "johnsmith3@mail.com"))))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(List<List<String>> accounts, List<List<String>> expected) {
        // when
        final var actual = solution.accountsMerge(accounts);

        // then
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

}