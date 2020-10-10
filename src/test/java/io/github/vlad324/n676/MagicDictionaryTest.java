package io.github.vlad324.n676;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MagicDictionaryTest {
    @Test
    void should_produce_expected_result() {
        // given
        final var magicDictionary = new MagicDictionary();

        // when
        magicDictionary.buildDict(new String[]{"hello", "hhllo"});

        // then
        assertThat(magicDictionary.search("hello")).isTrue();
        assertThat(magicDictionary.search("hhllo")).isTrue();
        assertThat(magicDictionary.search("hhlle")).isTrue();
        assertThat(magicDictionary.search("hhlee")).isFalse();
        assertThat(magicDictionary.search("hell")).isFalse();
        assertThat(magicDictionary.search("helloo")).isFalse();
        assertThat(magicDictionary.search("leetcode")).isFalse();
        assertThat(magicDictionary.search("")).isFalse();
    }

    @Test
    void should_produce_expected_result2() {
        // given
        final var magicDictionary = new MagicDictionary();

        // when
        magicDictionary.buildDict(new String[]{"a", "aa", "aaa"});

        // then
        assertThat(magicDictionary.search("aa")).isFalse();
        assertThat(magicDictionary.search("ab")).isTrue();
        assertThat(magicDictionary.search("ba")).isTrue();
        assertThat(magicDictionary.search("baa")).isTrue();
        assertThat(magicDictionary.search("b")).isTrue();
    }
}