package io.github.vlad324.n775;

/**
 * {@link "https://leetcode.com/problems/global-and-local-inversions/"}
 */
class Solution {
    public boolean isIdealPermutation(int[] A) {
        for (int i = 0; i < A.length; i++) {
            final var d = A[i] - i;
            if (d > 1 || d < -1) {
                return false;
            }
        }

        return true;
    }
}