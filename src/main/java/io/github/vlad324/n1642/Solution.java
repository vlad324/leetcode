package io.github.vlad324.n1642;

import java.util.PriorityQueue;

/**
 * {@link "https://leetcode.com/problems/furthest-building-you-can-reach/"}
 */
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        final var queue = new PriorityQueue<Integer>();
        for (int i = 0; i < heights.length - 1; i++) {
            int jump = heights[i + 1] - heights[i];

            if (jump <= 0) {
                continue;
            }

            queue.add(jump);
            if (queue.size() > ladders && (bricks -= queue.poll()) < 0) {
                return i;
            }
        }

        return heights.length - 1;
    }
}
