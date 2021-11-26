package io.github.vlad324.n797;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/all-paths-from-source-to-target/"}
 */
class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null) {
            return Collections.emptyList();
        }

        final var result = new ArrayList<List<Integer>>();
        final var path = new LinkedList<Integer>();
        path.add(0);
        dfs(result, path, graph, 0, graph.length - 1);

        return result;
    }

    private void dfs(List<List<Integer>> result, LinkedList<Integer> path, int[][] graph, int current, int end) {
        if (current == end) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (final var next : graph[current]) {
            path.add(next);
            dfs(result, path, graph, next, end);
            path.removeLast();
        }
    }
}
