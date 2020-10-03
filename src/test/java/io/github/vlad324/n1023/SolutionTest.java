package io.github.vlad324.n1023;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
            arguments(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"},
                "FB",
                List.of(true, false, true, true, false)),
            arguments(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"},
                "FoBa",
                List.of(true, false, true, false, false)),
            arguments(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"},
                "FoBaT",
                List.of(false, true, false, false, false)),
            arguments(new String[]{"CompetitiveProgramming", "CounterPick", "ControlPanel"},
                "CooP",
                List.of(false, false, true)),
            arguments(new String[]{"aksvbjLiknuTzqon", "ksvjLimflkpnTzqn", "mmkasvjLiknTxzqn", "ksvjLiurknTzzqbn", "ksvsjLctikgnTzqn", "knzsvzjLiknTszqn"},
                "ksvjLiknTzqn",
                List.of(true, true, true, true, true, true))
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(String[] queries, String pattern, List<Boolean> expected) {
        // when
        final var actual = solution.camelMatch(queries, pattern);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}