package io.github.vlad324;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class TopKFrequentWordsTest {

    private final TopKFrequentWords frequentWords = new TopKFrequentWords();

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
            arguments(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2, List.of("i", "love")),
            arguments(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4,
                List.of("the", "is", "sunny", "day"))
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String[] words, int k, List<String> expected) {
        // when
        final var actual = frequentWords.topKFrequent(words, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}