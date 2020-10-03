package io.github.vlad324.n1029;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * {@link "https://leetcode.com/problems/two-city-scheduling/"}
 */
class Solution {

    public int twoCitySchedCost(int[][] costs) {
        final var half = costs.length / 2;

        final var queue = new PriorityQueue<>(Comparator.<int[]>comparingInt(array -> Math.abs(array[0] - array[1]))
            .reversed());
        queue.addAll(Arrays.asList(costs));

        int countA = 0;
        int countB = 0;
        int sum = 0;
        while (!queue.isEmpty()) {
            final var current = queue.poll();
            if ((current[0] < current[1] && countA < half) || countB == half) {
                sum += current[0];
                countA++;
            } else {
                sum += current[1];
                countB++;
            }
        }

        return sum;
    }
}
