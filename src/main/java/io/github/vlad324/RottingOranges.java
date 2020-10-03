package io.github.vlad324;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    private static final byte NEIGHBOR_ROW_POSITION = 0;
    private static final byte NEIGHBOR_COLUMN_POSITION = 1;
    private static final byte[][] NEIGHBORS = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    private static final int ROTTEN_ORANGE = 2;
    private static final int NORMAL_ORANGE = 1;

    private static final int[] DELIMITER = null;

    public int orangesRotting(int[][] grid) {
        int normalOranges = 0;
        final var rottenQueue = new LinkedList<int[]>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == NORMAL_ORANGE) {
                    normalOranges++;
                } else if (grid[i][j] == ROTTEN_ORANGE) {
                    rottenQueue.offer(new int[]{i, j});
                }
            }
        }

        if (normalOranges == 0) {
            return 0;
        }

        rottenQueue.add(DELIMITER);

        int daysCount = 0;
        while (!rottenQueue.isEmpty() && normalOranges != 0) {
            int[] coordinates;
            while (!Arrays.equals((coordinates = rottenQueue.poll()), DELIMITER)) {
                rot(grid, coordinates, rottenQueue);
            }

            if (!rottenQueue.isEmpty()) {
                daysCount++;
                normalOranges -= rottenQueue.size();
                rottenQueue.offer(DELIMITER);
            }
        }

        return normalOranges == 0 ? daysCount : -1;
    }

    private void rot(int[][] grid, int[] coordinates, Queue<int[]> rottenQueue) {
        for (final byte[] neighbor : NEIGHBORS) {
            int i = coordinates[0] + neighbor[NEIGHBOR_ROW_POSITION];
            int j = coordinates[1] + neighbor[NEIGHBOR_COLUMN_POSITION];

            if (isAllowed(grid, i, j) && grid[i][j] == NORMAL_ORANGE) {
                grid[i][j]++;
                rottenQueue.offer(new int[]{i, j});
            }
        }
    }

    private boolean isAllowed(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length
            && j >= 0 && j < grid[0].length;
    }
}
