package io.github.vlad324.n797n;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * {@link "https://leetcode.com/problems/all-paths-from-source-to-target/"}
 */
class Solution {


    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null) {
            return Collections.emptyList();
        }

        return dfs(graph, 0, graph.length - 1);
    }

    private List<List<Integer>> dfs(int[][] graph, int start, int end) {
        final var result = new LinkedList<List<Integer>>();
        var path = new LinkedList<Integer>();

        final var nodes = new Stack<Integer>();
        nodes.push(start);
        while (!nodes.isEmpty()) {
            final var current = nodes.peek();

            if (current == end) {
                result.add(path);
                path = new LinkedList<>();
            }

            path.add(current);
        }

        return Collections.emptyList();
    }
}
