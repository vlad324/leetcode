package io.github.vlad324.n1606;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * {@link "https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests/"}
 */
class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        final var requestCounts = new HashMap<Integer, Integer>();

        final var serversLoad = new PriorityQueue<Node>();
        final var free = new TreeSet<Integer>();
        for (int i = 0; i < k; i++) {
            free.add(i);
        }

        int maxRequestCount = 0;
        for (int i = 0; i < arrival.length; i++) {
            while (!serversLoad.isEmpty() && serversLoad.peek().nextAvailable <= arrival[i]) {
                free.add(serversLoad.poll().serverIndex);
            }

            var serverIndex = free.ceiling(i % k);
            if (serverIndex == null && ((serverIndex = free.ceiling(0)) == null)) {
                continue;
            }

            free.remove(serverIndex);
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
