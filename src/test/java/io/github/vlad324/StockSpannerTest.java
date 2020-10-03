package io.github.vlad324;

import static io.github.vlad324.StockSpannerTest.Params.params;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;


class StockSpannerTest {

    private final StockSpanner spanner = new StockSpanner();

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void should_produce_expected_result(List<Params> testParams) {
        for (final var p : testParams) {
            // when
            final var actual = spanner.next(p.price);

            // then
            assertThat(actual)
                .as("Not equals for %s", p)
                .isEqualTo(p.daysCount);
        }
    }

    private static Stream<List<Params>> testDataProvider() {
        return Stream.of(
            List.of(
                params(100, 1),
                params(80, 1),
                params(60, 1),
                params(70, 2),
                params(60, 1),
                params(75, 4),
                params(85, 6)
            ), List.of(
                params(1, 1),
                params(1, 2),
                params(1, 3),
                params(1, 4),
                params(1, 5),
                params(1, 6),
                params(1, 7)
            ), List.of(
                params(1, 1),
                params(2, 2),
                params(3, 3),
                params(4, 4),
                params(5, 5),
                params(6, 6),
                params(7, 7)
            )
        );
    }

    public static class Params {
        public final int price;
        public final int daysCount;

        private Params(int price, int daysCount) {
            this.price = price;
            this.daysCount = daysCount;
        }

        public static Params params(int price, int daysCount) {
            return new Params(price, daysCount);
        }

        @Override
        public String toString() {
            return "TestParam{" +
                "price=" + price +
                ", daysCount=" + daysCount +
                '}';
        }
    }
}