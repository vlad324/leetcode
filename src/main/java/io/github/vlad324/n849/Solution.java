package io.github.vlad324.n849;

/**
 * {@link "https://leetcode.com/problems/maximize-distance-to-closest-person/"}
 */
class Solution {
    public int maxDistToClosest(int[] seats) {
        int max = 1;
        int previousOccupied = -1;
        int nextOccupied = getNextOccupied(seats, 0);

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                while (i > nextOccupied) {
                    previousOccupied = nextOccupied;
                    nextOccupied = getNextOccupied(seats, nextOccupied + 1);
                }

                int minDistance;
                if (nextOccupied == seats.length) {
                    minDistance = i - previousOccupied;
                } else if (previousOccupied == -1) {
                    minDistance = nextOccupied - i;
                } else {
                    minDistance = Math.min(i - previousOccupied, nextOccupied - i);
                }

                max = Math.max(max, minDistance);
            }
        }

        return max;
    }

    public int getNextOccupied(int[] seats, int i) {
        while (i < seats.length && seats[i] != 1) {
            i++;
        }

        return i;
    }
}