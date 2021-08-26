package io.github.vlad324.n331;

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
            .add(arguments("9,3,4,#,#,1,#,#,2,#,6,#,#", true))
            .add(arguments("1,#", false))
            .add(arguments("9,#,#,1", false))
            .add(arguments("9,#,#,1,#,#", false))
            .add(arguments("1,#,#,#,#", false))
            .add(arguments("1,#,#,#,#", false))
            .add(arguments("#", true))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String preorder, boolean expected) {
        // when
        final var actual = solution.isValidSerialization(preorder);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}