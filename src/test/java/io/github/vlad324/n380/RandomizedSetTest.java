package io.github.vlad324.n380;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RandomizedSetTest {
    private final RandomizedSet randomizedSet = new RandomizedSet();

    @Test
    void should_produce_expected_result() {
        // given
        assertThat(randomizedSet.remove(0)).isFalse();
        assertThat(randomizedSet.remove(0)).isFalse();

        assertThat(randomizedSet.insert(-1)).isTrue();

        // when
        final var actual = randomizedSet.getRandom();

        // then
        assertThat(actual).isEqualTo(-1);
    }
}