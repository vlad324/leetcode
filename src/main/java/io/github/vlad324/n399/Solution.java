package io.github.vlad324.n399;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.function.Function;

/**
 * {@link "https://leetcode.com/problems/evaluate-division/"}
 */
class Solution {

    private static final Function<String, List<Node>> NEW_LIST_CREATOR = (key) -> new LinkedList<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        final var graph = new HashMap<String, List<Node>>();

        for (int i = 0; i < equations.size(); i++) {
            final var dividend = equations.get(i).get(0);
            final var divisor = equations.get(i).get(1);

            graph.computeIfAbsent(dividend, NEW_LIST_CREATOR)
                .add(new Node(divisor, values[i]));

            graph.computeIfAbsent(divisor, NEW_LIST_CREATOR)
                .add(new Node(dividend, 1 / values[i]));
        }

        final var result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            final var dividend = queries.get(i).get(0);
            final var divisor = queries.get(i).get(1);

            if (graph.containsKey(dividend) && graph.containsKey(divisor)) {
//                result[i] = dfs(dividend, divisor, new HashSet<>(), graph, 1.0d);
                result[i] = dfs2(dividend, divisor, graph);
            } else {
                result[i] = -1;
            }
        }

        return result;
    }

    private double dfs(String source, String target, Set<String> visited, Map<String, List<Node>> graph, double value) {
        if (source.equals(target)) {
            return value;
        }

        visited.add(source);

        final var nodes = graph.get(source);
        if (nodes == null) {
            return -1;
        }

        for (final var n : nodes) {
            if (!visited.contains(n.divisor)) {
                final var v = dfs(n.divisor, target, visited, graph, value * n.value);

                if (v > 0) {
                    return v;
                }
            }
        }

        return -1;
    }

    private double dfs2(String source, String target, Map<String, List<Node>> graph) {
        final var stack = new Stack<Node>();
        final var visited = new HashSet<String>();

        stack.push(new Node(source, 1));

        while (!stack.isEmpty()) {
            final var current = stack.pop();

            if (current.divisor.equals(target)) {
                return current.value;
            }

            visited.add(current.divisor);
            final var nodes = graph.get(current.divisor);

            if (nodes == null) {
                continue;
            }

            for (final var n : nodes) {
                if (!visited.contains(n.divisor)) {
                    stack.push(new Node(n.divisor, n.value * current.value));
                }
            }
        }

        return -1;
    }

    private static class Node {
        String divisor;
        double value;

        public Node(String divisor, double value) {
            this.divisor = divisor;
            this.value = value;
        }
    }
}
