package io.github.vlad324.n307;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NumArrayTest {

    @Test
    void should_produce_expected_result() {
        // given
        final var numArray = new NumArray(new int[]{1, 3, 5});

        // then
        assertThat(numArray.sumRange(0, 2)).isEqualTo(9);
        numArray.update(1, 2);
        assertThat(numArray.sumRange(0, 2)).isEqualTo(8);
    }
}