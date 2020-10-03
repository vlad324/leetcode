package io.github.vlad324.n278;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void should_produce_expected_result() {
        // when
        final var actual = solution.firstBadVersion(10);

        // then
        assertThat(actual).isEqualTo(2);
    }
}