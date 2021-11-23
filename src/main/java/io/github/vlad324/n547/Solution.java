package io.github.vlad324.n547;

import java.util.LinkedList;

/**
 * {@link "https://leetcode.com/problems/number-of-provinces/"}
 */
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        int result = 0;
        final var visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            result++;
            visit(isConnected, i, visited);
        }

        return result;
    }

    private void visit(int[][] isConnected, int i, boolean[] visited) {
        final var queue = new LinkedList<Integer>();
        queue.add(i);
        while (!queue.isEmpty()) {
            final var current = queue.poll();
            if (visited[current]) {
                continue;
            }

            visited[current] = true;

            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[current][j] == 1 && !visited[j]) {
                    queue.add(j);
                }
            }
        }
    }
}
