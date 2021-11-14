package io.github.vlad324.n1286;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CombinationIteratorTest {
    @Test
    void should_produce_expected_result() {
        // given
        final var iterator = new CombinationIterator("abc", 2);

        // then
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo("ab");

        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo("ac");

        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo("bc");

        assertThat(iterator.hasNext()).isFalse();
    }
}