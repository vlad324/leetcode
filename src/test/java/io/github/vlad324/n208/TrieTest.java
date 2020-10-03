package io.github.vlad324.n208;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class TrieTest {

    private final Trie trie = new Trie();

    @Test
    void should_return_expected_result() {
        trie.insert("apple");

        assertThat(trie.search("apple")).isTrue();
        assertThat(trie.search("app")).isFalse();
        assertThat(trie.startsWith("app")).isTrue();
        assertThat(trie.startsWith("appa")).isFalse();

        trie.insert("app");

        assertThat(trie.search("app")).isTrue();
    }
}