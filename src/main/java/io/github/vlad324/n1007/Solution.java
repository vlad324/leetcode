package io.github.vlad324.n1007;

/**
 * {@link "https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/"}
 */
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        final int n = A.length;

        int[] aCount = new int[6];
        int[] bCount = new int[6];
        for (int i = 0; i < n; i++) {
            aCount[A[i] - 1]++;
            bCount[B[i] - 1]++;
        }

        int candidate = -1;
        for (int i = 0; i < 6; i++) {
            final var sum = aCount[i] + bCount[i];
            if (sum >= n) {
                candidate = i;
                break;
            }
        }

        if (candidate == -1) {
            return -1;
        }

        return verify(candidate + 1, A, B);
    }

    private int verify(int candidate, int[] a, int[] b) {
        int up = 0;
        int down = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i] && a[i] == candidate) {
                continue;
            }

            if (a[i] == candidate) {
                up++;
            } else if (b[i] == candidate) {
                down++;
            } else {
                return -1;
            }
        }

        return Math.min(up, down);
    }
}
