package io.github.vlad324.n1462;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * {@link "https://leetcode.com/problems/course-schedule-iv/"}
 */
class Solution {

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        final var map = new HashMap<Integer, Set<Integer>>();

        for (int[] prerequisite : prerequisites) {
            if (map.containsKey(prerequisite[1])) {
                map.get(prerequisite[1]).add(prerequisite[0]);
            } else {
                final var p = new HashSet<Integer>();
                p.add(prerequisite[0]);
                map.put(prerequisite[1], p);
            }
        }

        final var result = new ArrayList<Boolean>();
        for (int i = 0; i < queries.length; i++) {
            final var visited = new boolean[n];
            result.add(isPrerequisite(queries[i][0], queries[i][1], map, visited));
        }

        return result;
    }

    private Boolean isPrerequisite(int prerequisite, int forCourse, Map<Integer, Set<Integer>> map, boolean[] visited) {
        if (visited[forCourse]) {
            return false;
        }
        visited[forCourse] = true;

        final var prerequisites = map.get(forCourse);

        if (prerequisites == null) {
            return false;
        }

        if (prerequisites.contains(prerequisite)) {
            return true;
        }

        for (final var p : prerequisites) {
            if (isPrerequisite(prerequisite, p, map, visited)) {
                return true;
            }
        }

        return false;
    }
}
