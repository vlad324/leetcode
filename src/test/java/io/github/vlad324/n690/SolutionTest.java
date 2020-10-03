package io.github.vlad324.n690;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.n690.Solution.Employee;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
            arguments(List.of(
                new Employee(1, 5, List.of(2, 3)),
                new Employee(2, 3),
                new Employee(3, 3)
            ), 1, 11)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(List<Employee> employees, int id, int expected) {
        // when
        final var actual = solution.getImportance(employees, id);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}