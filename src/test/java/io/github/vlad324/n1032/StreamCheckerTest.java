package io.github.vlad324.n1032;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StreamCheckerTest {

    @Test
    void should_produce_expected_result2() {
        // given
        final var streamChecker = new StreamChecker(new String[]{"ab", "ba", "aaab", "abab", "baa"});

        // then
        assertThat(streamChecker.query('a')).isFalse();
        assertThat(streamChecker.query('a')).isFalse();
        assertThat(streamChecker.query('a')).isFalse();
        assertThat(streamChecker.query('a')).isFalse();
        assertThat(streamChecker.query('a')).isFalse();
        assertThat(streamChecker.query('b')).isTrue();
        assertThat(streamChecker.query('a')).isTrue();
        assertThat(streamChecker.query('b')).isTrue();
        assertThat(streamChecker.query('a')).isTrue();
        assertThat(streamChecker.query('b')).isTrue();
        assertThat(streamChecker.query('b')).isFalse();
        assertThat(streamChecker.query('b')).isFalse();
        assertThat(streamChecker.query('a')).isTrue();
        assertThat(streamChecker.query('b')).isTrue();
        assertThat(streamChecker.query('a')).isTrue();
    }

    @Test
    void should_produce_expected_result() {
        // given
        final var streamChecker = new StreamChecker(new String[]{"cd", "f", "kl"});

        // then
        assertThat(streamChecker.query('a')).isFalse();
        assertThat(streamChecker.query('b')).isFalse();

        assertThat(streamChecker.query('c')).isFalse();
        assertThat(streamChecker.query('d')).isTrue();

        assertThat(streamChecker.query('e')).isFalse();

        assertThat(streamChecker.query('f')).isTrue();

        assertThat(streamChecker.query('g')).isFalse();
        assertThat(streamChecker.query('h')).isFalse();
        assertThat(streamChecker.query('i')).isFalse();
        assertThat(streamChecker.query('j')).isFalse();

        assertThat(streamChecker.query('k')).isFalse();
        assertThat(streamChecker.query('l')).isTrue();
    }
}