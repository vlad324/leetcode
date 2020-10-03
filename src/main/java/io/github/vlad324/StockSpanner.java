package io.github.vlad324;

import java.util.Stack;

/**
 * {@link "https://leetcode.com/problems/online-stock-span/"}
 */
public class StockSpanner {

    private final Stack<Pair> prices;

    public StockSpanner() {
        this.prices = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!prices.empty() && prices.peek().price <= price) {
            span += prices.pop().span;
        }

        prices.push(new Pair(price, span));

        return span;
    }

    private static class Pair {
        public final int price;
        public final int span;

        public Pair(int price, int span) {
            this.price = price;
            this.span = span;
        }
    }
}
