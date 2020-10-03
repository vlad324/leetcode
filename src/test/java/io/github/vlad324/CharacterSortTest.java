package io.github.vlad324;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CharacterSortTest {

    private final CharacterSort characterSort = new CharacterSort();

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
            arguments("tree", "eetr"),
            arguments("cccaaa", "cccaaa"),
            arguments("Aabb", "bbaA"),
            arguments("", ""),
            arguments("loveleetcode", "eeeeoollvtdc")
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String input, String expected) {
        // when
        final var actual = characterSort.frequencySort(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}