package io.github.vlad324.n1603;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ParkingSystemTest {

    @Test
    void should_produce_expected_result() {
        // given
        final var parkingSystem = new ParkingSystem(0, 1, 2);

        // then
        assertThat(parkingSystem.addCar(1)).isFalse();
        assertThat(parkingSystem.addCar(2)).isTrue();
        assertThat(parkingSystem.addCar(3)).isTrue();
        assertThat(parkingSystem.addCar(3)).isTrue();
        assertThat(parkingSystem.addCar(3)).isFalse();
        assertThat(parkingSystem.addCar(1)).isFalse();
    }

}