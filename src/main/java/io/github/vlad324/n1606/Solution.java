package io.github.vlad324.n1606;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * {@link "https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests/"}
 */
class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        final var requestCounts = new HashMap<Integer, Integer>();

        final var serversLoad = new PriorityQueue<Node>();
        final var busy = new boolean[k];

        int maxRequestCount = 0;
        for (int i = 0; i < arrival.length; i++) {
            while (!serversLoad.isEmpty() && serversLoad.peek().nextAvailable <= arrival[i]) {
                busy[serversLoad.poll().serverIndex] = false;
            }

            var serverIndex = i % k;
            serverIndex = findAvailableServerIndex(k, busy, serverIndex);

            if (serverIndex == -1) {
                continue;
            }

            busy[serverIndex] = true;
            serversLoad.add(new Node(serverIndex, arrival[i] + load[i]));

            final var newCount = requestCounts.compute(serverIndex, (key, value) -> value == null ? 1 : value + 1);
            if (newCount > maxRequestCount) {
                maxRequestCount = newCount;
            }
        }

        final var result = new LinkedList<Integer>();
        for (final var entry : requestCounts.entrySet()) {
            if (entry.getValue() == maxRequestCount) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    private int findAvailableServerIndex(int k, boolean[] busy, int serverIndex) {
        for (int i = serverIndex; i < k; i++) {
            if (!busy[i]) {
                return i;
            }
        }

        for (int i = 0; i < serverIndex; i++) {
            if (!busy[i]) {
                return i;
            }
        }

        return -1;
    }

    private static class Node implements Comparable<Node> {
        int serverIndex;
        int nextAvailable;

        public Node(int serverIndex, int nextAvailable) {
            this.serverIndex = serverIndex;
            this.nextAvailable = nextAvailable;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.nextAvailable, o.nextAvailable);
        }
    }
}
