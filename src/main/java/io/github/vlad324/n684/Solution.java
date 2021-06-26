package io.github.vlad324.n684;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@link "https://leetcode.com/problems/redundant-connection/"}
 */
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        final var graph = new HashMap<Integer, List<Integer>>();

        for (final var edge : edges) {
            if (dsf(graph, edge[0], edge[1], new boolean[edges.length])) {
                return edge;
            }

            graph.computeIfAbsent(edge[0], __ -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], __ -> new ArrayList<>()).add(edge[0]);
        }

        return new int[0];
    }

    private boolean dsf(Map<Integer, List<Integer>> graph, int start, int end, boolean[] seen) {
        if (start == end) {
            return true;
        }

        if (seen[start - 1]) {
            return false;
        }

        seen[start - 1] = true;
        for (final var next : graph.getOrDefault(start, Collections.emptyList())) {
            if (dsf(graph, next, end, seen)) {
                return true;
            }
        }

        return false;
    }
}
