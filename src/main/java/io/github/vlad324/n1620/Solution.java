package io.github.vlad324.n1620;

/**
 * {@link "https://leetcode.com/problems/coordinate-with-maximum-network-quality/"}
 */
class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        final var distances = new Double[towers.length][towers.length];

        int maxSignal = 0;
        int maxIndex = 0;
        for (int i = 0; i < towers.length; i++) {
            int signal = 0;
            for (int j = 0; j < towers.length; j++) {
                if (i == j) {
                    signal += towers[j][2];
                    continue;
                }

                final var d = distance(towers, i, j, distances);
                if (d <= radius) {
                    signal += towers[j][2] / (1 + d);
                }
            }

            if (signal > maxSignal) {
                maxSignal = signal;
                maxIndex = i;
            } else if (signal == maxSignal) {
                final var dx = towers[maxIndex][0] - towers[i][0];
                if (dx > 0 || (dx == 0 && towers[maxIndex][1] - towers[i][1] > 0)) {
                    maxIndex = i;
                }
            }
        }

        return new int[]{towers[maxIndex][0], towers[maxIndex][1]};
    }

    private double distance(int[][] towers, int i, int j, Double[][] distances) {
        if (distances[i][j] != null) {
            return distances[i][j];
        }

        final var d = distance(towers[i][0], towers[i][1], towers[j][0], towers[j][1]);
        distances[i][j] = d;
        distances[j][i] = d;
        return d;
    }

    private double distance(int x1, int y1, int x2, int y2) {
        int dx = x1 - x2;
        int dy = y1 - y2;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
