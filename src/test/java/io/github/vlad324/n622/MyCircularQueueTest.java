package io.github.vlad324.n622;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MyCircularQueueTest {

    @Test
    void should_produce_expected_result() {
        // given
        final var myCircularQueue = new MyCircularQueue(3);

        // then
        assertThat(myCircularQueue.deQueue()).isFalse();
        assertThat(myCircularQueue.Rear()).isEqualTo(-1);
        assertThat(myCircularQueue.Front()).isEqualTo(-1);
        assertThat(myCircularQueue.isFull()).isFalse();
        assertThat(myCircularQueue.isEmpty()).isTrue();


        assertThat(myCircularQueue.enQueue(1)).isTrue();
        assertThat(myCircularQueue.Rear()).isEqualTo(1);
        assertThat(myCircularQueue.Front()).isEqualTo(1);
        assertThat(myCircularQueue.isFull()).isFalse();
        assertThat(myCircularQueue.isEmpty()).isFalse();


        assertThat(myCircularQueue.enQueue(2)).isTrue();
        assertThat(myCircularQueue.enQueue(3)).isTrue();
        assertThat(myCircularQueue.enQueue(4)).isFalse();
        assertThat(myCircularQueue.Rear()).isEqualTo(3);
        assertThat(myCircularQueue.isFull()).isTrue();
        assertThat(myCircularQueue.deQueue()).isTrue();
        assertThat(myCircularQueue.enQueue(4)).isTrue();
        assertThat(myCircularQueue.Rear()).isEqualTo(4);
        assertThat(myCircularQueue.Front()).isEqualTo(2);
    }
}