package io.github.vlad324.n1192;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@link "https://leetcode.com/problems/critical-connections-in-a-network/"}
 */
class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        final var graph = new HashMap<Integer, List<Integer>>();
        for (final var connection : connections) {
            int a = connection.get(0);
            int b = connection.get(1);
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        final var rank = new int[n];
        for (int i = 0; i < n; ++i) {
            rank[i] = i;
        }

        final var visited = new boolean[n];
        int prevNode = -1, curNode = 0, curRank = 0;
        final var result = new ArrayList<List<Integer>>();
        dfs(visited, rank, prevNode, curNode, curRank, graph, result);
        return result;
    }

    private void dfs(boolean[] visited,
                     int[] ranks,
                     int previous,
                     int current,
                     int currentRank,
                     Map<Integer, List<Integer>> graph,
                     List<List<Integer>> result) {
        ranks[current] = currentRank;
        visited[current] = true;
        for (int neighbor : graph.get(current)) {
            if (neighbor == previous) {
                continue;
            }

            if (!visited[neighbor]) {
                dfs(visited, ranks, current, neighbor, currentRank + 1, graph, result);
            }

            ranks[current] = Math.min(ranks[current], ranks[neighbor]);
            if (ranks[neighbor] == currentRank + 1) {
                result.add(List.of(current, neighbor));
            }
        }
    }
}
