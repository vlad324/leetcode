package io.github.vlad324.n622;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MyCircularQueueTest {

    @Test
    void should_produce_expected_result() {
        // given
        final var queue = new MyCircularQueue(3);

        // then
        assertThat(queue.deQueue()).isFalse();
        assertThat(queue.Rear()).isEqualTo(-1);
        assertThat(queue.Front()).isEqualTo(-1);
        assertThat(queue.isFull()).isFalse();
        assertThat(queue.isEmpty()).isTrue();


        assertThat(queue.enQueue(1)).isTrue();
        assertThat(queue.Rear()).isEqualTo(1);
        assertThat(queue.Front()).isEqualTo(1);
        assertThat(queue.isFull()).isFalse();
        assertThat(queue.isEmpty()).isFalse();


        assertThat(queue.enQueue(2)).isTrue();
        assertThat(queue.Rear()).isEqualTo(2);
        assertThat(queue.Front()).isEqualTo(1);
        assertThat(queue.isFull()).isFalse();
        assertThat(queue.isEmpty()).isFalse();

        assertThat(queue.enQueue(3)).isTrue();
        assertThat(queue.Rear()).isEqualTo(3);
        assertThat(queue.Front()).isEqualTo(1);
        assertThat(queue.isFull()).isTrue();
        assertThat(queue.isEmpty()).isFalse();

        assertThat(queue.enQueue(4)).isFalse();

        assertThat(queue.deQueue()).isTrue();
        assertThat(queue.Rear()).isEqualTo(3);
        assertThat(queue.Front()).isEqualTo(2);
        assertThat(queue.isFull()).isFalse();
        assertThat(queue.isEmpty()).isFalse();

        assertThat(queue.enQueue(4)).isTrue();
        assertThat(queue.Rear()).isEqualTo(4);
        assertThat(queue.Front()).isEqualTo(2);
        assertThat(queue.isFull()).isTrue();
        assertThat(queue.isEmpty()).isFalse();
    }
}