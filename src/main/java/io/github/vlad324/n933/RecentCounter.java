package io.github.vlad324.n933;

import java.util.LinkedList;
import java.util.Queue;

/**
 * {@link "https://leetcode.com/problems/number-of-recent-calls/"}
 */
class RecentCounter {

    private final Queue<Integer> queue;

    public RecentCounter() {
        this.queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);

        int lowerBound = t - 3000;
        while (queue.peek() < lowerBound) {
            queue.poll();
        }

        return queue.size();
    }
}