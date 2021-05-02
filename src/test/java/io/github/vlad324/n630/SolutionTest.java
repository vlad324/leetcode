package io.github.vlad324.n630;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments(new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}}, 3))
            .add(arguments(new int[][]{{1, 2}}, 1))
            .add(arguments(new int[][]{{3, 2}, {4, 3}}, 0))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[][] courses, int expected) {
        // when
        final var actual = solution.scheduleCourse(courses);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}