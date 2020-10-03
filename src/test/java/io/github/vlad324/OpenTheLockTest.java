package io.github.vlad324;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class OpenTheLockTest {

    private final OpenTheLock lock = new OpenTheLock();

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
            arguments(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202", 6),
            arguments(new String[]{"8888"}, "0009", 1),
            arguments(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888", -1),
            arguments(new String[]{"0000"}, "8888", -1),
            arguments(new String[]{"1210", "1001", "1012", "0122", "2011"}, "0200", 2)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String[] deadends, String target, int expected) {
        // when
        final var actual = lock.openLock2(deadends, target);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}