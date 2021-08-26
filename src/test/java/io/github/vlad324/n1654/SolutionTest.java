package io.github.vlad324.n1654;

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
//            .add(arguments(new int[]{14, 4, 18, 1, 15}, 3, 15, 9, 3))
//            .add(arguments(new int[]{8, 3, 16, 6, 12, 20}, 15, 13, 11, -1))
//            .add(arguments(new int[]{1, 6, 2, 14, 5, 17, 4}, 16, 9, 7, 2))
//            .add(arguments(new int[]{18, 13, 3, 9, 8, 14}, 3, 8, 6, -1))
//            .add(arguments(new int[]{198, 159, 151, 166, 33, 155, 90, 43, 104, 102, 186, 137, 2, 3, 24, 139, 150, 5},
//                144, 89, 199, 3))
            .add(arguments(new int[]{162,118,178,152,167,100,40,74,199,186,26,73,200,127,30,124,193,84,184,36,103,149,153,9,54,154,133,95,45,198,79,157,64,122,59,71,48,177,82,35,14,176,16,108,111,6,168,31,134,164,136,72,98},
                29, 98, 80, 121))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(int[] forbidden, int a, int b, int x, int expected) {
        // when
        final var actual = solution.minimumJumps(forbidden, a, b, x);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}