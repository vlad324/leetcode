package io.github.vlad324.n332;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * {@link "https://leetcode.com/problems/reconstruct-itinerary/"}
 */
class Solution {

    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.isEmpty()) {
            return Collections.emptyList();
        }

        final var map = new HashMap<String, PriorityQueue<String>>();
        for (final var ticket : tickets) {
            final var queue = map.getOrDefault(ticket.get(0), new PriorityQueue<>());
            queue.add(ticket.get(1));
            map.put(ticket.get(0), queue);
        }

        final var result = new LinkedList<String>();
        dfs("JFK", map, result);

        return result;
    }

    public void dfs(String from, Map<String, PriorityQueue<String>> map, List<String> result) {
        final var queue = map.get(from);
        while (queue != null && !queue.isEmpty()) {
            dfs(queue.poll(), map, result);
        }

        result.add(0, from);
    }

}
