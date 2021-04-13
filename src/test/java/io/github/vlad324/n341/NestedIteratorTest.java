package io.github.vlad324.n341;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.vlad324.n341.NestedIterator.NestedInteger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class NestedIteratorTest {

    private static class NestedIntegerImpl implements NestedInteger {

        private final Integer integer;
        private final List<NestedInteger> list;

        private NestedIntegerImpl(Integer integer, List<NestedInteger> list) {
            this.integer = integer;
            this.list = list;
        }

        @Override
        public boolean isInteger() {
            return integer != null;
        }

        @Override
        public Integer getInteger() {
            return isInteger() ? integer : null;
        }

        @Override
        public List<NestedInteger> getList() {
            return isInteger() ? null : list;
        }
    }

    public static NestedInteger integer(Integer integer) {
        return new NestedIntegerImpl(integer, null);
    }

    public static NestedInteger list(NestedInteger... list) {
        return new NestedIntegerImpl(null, Arrays.asList(list));
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.<Arguments>builder()
            .add(arguments(
                List.of(list(integer(1), integer(1)), integer(2), list(integer(1), integer(1))),
                List.of(1, 1, 2, 1, 1)
            ))
            .add(arguments(
                List.of(integer(1), list(integer(4), list(integer(6)))),
                List.of(1, 4, 6)
            ))
            .add(arguments(
                List.of(integer(1), list(integer(4), list())),
                List.of(1, 4)
            ))
            .build();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(List<NestedInteger> nestedList, List<Integer> expected) {
        // given
        final var nestedIterator = new NestedIterator(nestedList);

        // when
        final var actual = new ArrayList<Integer>();
        while (nestedIterator.hasNext()) {
            actual.add(nestedIterator.next());
        }

        // then
        assertThat(actual).isEqualTo(expected);
    }

}