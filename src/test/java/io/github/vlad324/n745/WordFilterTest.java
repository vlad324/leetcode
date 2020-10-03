package io.github.vlad324.n745;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class WordFilterTest {

    @Test
    void should_produce_expected_result() {
        // given
        final var wordFilter = new WordFilter(new String[]{"apple"});

        // then
        assertThat(wordFilter.f("a", "e")).isEqualTo(0);
        assertThat(wordFilter.f("apple", "le")).isEqualTo(0);
        assertThat(wordFilter.f("apple", "apple")).isEqualTo(0);
        assertThat(wordFilter.f("b", "e")).isEqualTo(-1);
    }

    @Test
    void should_produce_expected_result2() {
        // given
        final var wordFilter = new WordFilter(new String[]{"a", "aa", "aaa", "aaaa", "aaaaa"});

        // then
        assertThat(wordFilter.f("a", "a")).isEqualTo(4);
    }

    @Test
    void should_produce_expected_result3() {
        // given
        final var wordFilter = new WordFilter(new String[]{"cabaabaaaa", "ccbcababac", "bacaabccba",
            "bcbbcbacaa", "abcaccbcaa", "accabaccaa", "cabcbbbcca", "ababccabcb",
            "caccbbcbab", "bccbacbcba"});

        // then
        assertThat(wordFilter.f("bccbacbcba", "a")).isEqualTo(9);
        assertThat(wordFilter.f("ab", "abcaccbcaa")).isEqualTo(4);
        assertThat(wordFilter.f("a", "aa")).isEqualTo(5);
        assertThat(wordFilter.f("cabaaba", "abaaaa")).isEqualTo(0);
        assertThat(wordFilter.f("cacc", "accbbcbab")).isEqualTo(8);
        assertThat(wordFilter.f("ccbcab", "bac")).isEqualTo(1);
        assertThat(wordFilter.f("bac", "cba")).isEqualTo(2);
        assertThat(wordFilter.f("ac", "accabaccaa")).isEqualTo(5);
        assertThat(wordFilter.f("bcbb", "aa")).isEqualTo(3);
        assertThat(wordFilter.f("ccbca", "cbcababac")).isEqualTo(1);
    }
}