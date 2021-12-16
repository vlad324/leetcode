package io.github.vlad324.n310;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * {@link "https://leetcode.com/problems/minimum-height-trees/"}
 */
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n < 3) {
            return IntStream.range(0, n).boxed().collect(Collectors.toList());
        }

        final var graph = initGraph(n, edges);

        final var leaves = new LinkedList<Integer>();
        for (int i = 0; i < graph.size(); i++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        while (n > 2) {
            final var size = leaves.size();
            n -= size;

            for (int i = 0; i < size; i++) {
                final var leaf = leaves.poll();
                final var parent = graph.get(leaf).iterator().next();
                final var parentNeighbours = graph.get(parent);
                parentNeighbours.remove(leaf);
                if (parentNeighbours.size() == 1) {
                    leaves.add(parent);
                }
            }
        }

        return leaves;
    }

    private List<Set<Integer>> initGraph(int n, int[][] edges) {
        final var result = new ArrayList<Set<Integer>>();
        for (int i = 0; i < n; i++) {
            result.add(new HashSet<>());
        }

        for (final var e : edges) {
            result.get(e[0]).add(e[1]);
            result.get(e[1]).add(e[0]);
        }

        return result;
    }
}
