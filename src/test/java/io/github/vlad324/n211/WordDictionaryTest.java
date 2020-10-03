package io.github.vlad324.n211;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class WordDictionaryTest {

    private final WordDictionary wordDictionary = new WordDictionary();

    @Test
    void should_return_expected_result() {
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        assertThat(wordDictionary.search("pad")).isFalse();
        assertThat(wordDictionary.search("dad")).isTrue();
        assertThat(wordDictionary.search("mad")).isTrue();
        assertThat(wordDictionary.search(".ad")).isTrue();
        assertThat(wordDictionary.search("b..")).isTrue();
        assertThat(wordDictionary.search("b.")).isFalse();
    }
}