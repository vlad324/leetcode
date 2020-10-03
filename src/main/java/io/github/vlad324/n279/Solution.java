package io.github.vlad324.n279;

import java.util.LinkedList;

/**
 * {@link "https://leetcode.com/problems/perfect-squares/"}
 */
class Solution {

    public int numSquares(int n) {
        final var squares = new LinkedList<Integer>();
        int square;
        for (int i = (int) Math.sqrt(n); (square = i * i) > 0; i--) {
            squares.add(square);
        }

        final var queue = new LinkedList<Integer>();
        queue.offer(n);
        queue.offer(null);

        int num = 1;
        while (true) {
            final var current = queue.poll();

            if (current == null) {
                num++;
                queue.add(null);
                continue;
            }

            for (final var s : squares) {
                final var diff = current - s;

                if (diff == 0) {
                    return num;
                }

                if (diff > 0) {
                    queue.offer(diff);
                }
            }
        }
    }
}
