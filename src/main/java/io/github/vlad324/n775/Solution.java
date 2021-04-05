package io.github.vlad324.n775;

/**
 * {@link "https://leetcode.com/problems/global-and-local-inversions/"}
 */
class Solution {
    public boolean isIdealPermutation(int[] A) {
        int local = 0;
        int[] positions = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (i < A.length - 1 && A[i] > A[i + 1]) {
                local++;
            }

            positions[A[i]] = i;
        }

        int global = 0;
        for (int i = 0; i < positions.length; i++) {
            global += positions[i];
            for (int j = i - 1; j >= 0; j--) {
                if (positions[j] < positions[i]) {
                    global--;
                }
            }

            if (global > local) {
                return false;
            }
        }

        return global == local;
    }
}