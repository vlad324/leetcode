package io.github.vlad324.n648;

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
            arguments(List.of("cat", "bat", "rat"),
                "the cattle was rattled by the battery",
                "the cat was rat by the bat"),
            arguments(List.of("a", "b", "c"),
                "aadsfasf absbs bbab cadsfafs",
                "a a b c"),
            arguments(List.of("a", "aa", "aaa", "aaaa"),
                "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa",
                "a a a a a a a a bbb baba a"),
            arguments(List.of("catt", "cat", "bat", "rat"),
                "the cattle was rattled by the battery",
                "the cat was rat by the bat"),
            arguments(List.of("ac", "ab"),
                "it is abnormal that this solution is accepted",
                "it is ab that this solution is ac")
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(List<String> dictionary, String sentence, String expected) {
        // when
        final var actual = solution.replaceWords(dictionary, sentence);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}