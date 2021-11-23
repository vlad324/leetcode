package io.github.vlad324.n547;

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
        if (visited[i]) {
            return;
        }

        visited[i] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1) {
                visit(isConnected, j, visited);
            }
        }
    }
}
