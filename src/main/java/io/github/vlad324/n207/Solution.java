package io.github.vlad324.n207;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        final var map = new HashMap<Integer, List<Integer>>();

        for (final int[] prerequisite : prerequisites) {
            if (map.containsKey(prerequisite[0])) {
                map.get(prerequisite[0]).add(prerequisite[1]);
            } else {
                final var list = new LinkedList<Integer>();
                list.add(prerequisite[1]);
                map.put(prerequisite[0], list);
            }
        }

        final var visited = new boolean[numCourses];
        final var onStack = new boolean[numCourses];

        final var stack = new Stack<Integer>();

        for (int i = 0; i < numCourses; i++) {
            if (visited[i]) {
                continue;
            }

            stack.push(i);

            while (!stack.empty()) {
                final var current = stack.peek();

                if (visited[current]) {
                    stack.pop();
                    onStack[current] = false;
                    continue;
                } else {
                    visited[current] = true;
                    onStack[current] = true;
                }

                for (final var next : map.getOrDefault(current, Collections.emptyList())) {
                    if (onStack[next]) {
                        return false;
                    }

                    if (!visited[next]) {
                        stack.push(next);
                    }
                }
            }
        }

        return true;
    }
}
