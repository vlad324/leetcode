package io.github.vlad324.n933;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RecentCounterTest {

    @Test
    void should_produce_expected_result() {
        // given
        final var recentCounter = new RecentCounter();

        // then
        assertThat(recentCounter.ping(1)).isEqualTo(1);
        assertThat(recentCounter.ping(100)).isEqualTo(2);
        assertThat(recentCounter.ping(3001)).isEqualTo(3);
        assertThat(recentCounter.ping(3002)).isEqualTo(3);
    }
}