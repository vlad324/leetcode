package io.github.vlad324.n609;

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
            .add(arguments(new String[]{
                    "root/a 1.txt(abcd) 2.txt(efgh)",
                    "root/c 3.txt(abcd)",
                    "root/c/d 4.txt(efgh)",
                    "root 4.txt(efgh)"},
                List.of(
                    List.of("root/a/2.txt", "root/c/d/4.txt", "root/4.txt"),
                    List.of("root/a/1.txt", "root/c/3.txt")
                )))
            .add(arguments(new String[]{
                    "root/a 1.txt(abcd) 2.txt(efgh)",
                    "root/c 3.txt(abcd)",
                    "root/c/d 4.txt(efgh)"
                },
                List.of(
                    List.of("root/a/2.txt", "root/c/d/4.txt"),
                    List.of("root/a/1.txt", "root/c/3.txt")
                )))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String[] paths, List<List<String>> expected) {
        // when
        final var actual = solution.findDuplicate(paths);

        // then
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

}