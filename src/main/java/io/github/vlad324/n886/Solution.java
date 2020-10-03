package io.github.vlad324.n886;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * {@link "https://leetcode.com/problems/possible-bipartition/"}
 */
class Solution {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        final var map = new HashMap<Integer, List<Integer>>(n);

        for (final int[] dislikePair : dislikes) {
            if (map.containsKey(dislikePair[0] - 1)) {
                map.get(dislikePair[0] - 1).add(dislikePair[1] - 1);
            } else {
                final var disliked = new ArrayList<Integer>();
                disliked.add(dislikePair[1] - 1);
                map.put(dislikePair[0] - 1, disliked);
            }

            if (map.containsKey(dislikePair[1] - 1)) {
                map.get(dislikePair[1] - 1).add(dislikePair[0] - 1);
            } else {
                final var disliked = new ArrayList<Integer>();
                disliked.add(dislikePair[0] - 1);
                map.put(dislikePair[1] - 1, disliked);
            }
        }


        final int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                if (hasDuplicatedColor(i, map, visited)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean hasDuplicatedColor(int i, Map<Integer, List<Integer>> map, int[] visited) {
        final var stack = new Stack<Integer>();
        stack.push(i);
        visited[i] = 1;

        while (!stack.empty()) {
            final var current = stack.pop();

            for (final var next : map.getOrDefault(current, Collections.emptyList())) {
                if (visited[next] == visited[current]) {
                    return true;
                } else if (visited[next] == 0) {
                    visited[next] = -visited[current];
                    stack.push(next);
                }
            }
        }

        return false;
    }
}
