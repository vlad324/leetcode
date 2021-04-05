package io.github.vlad324.n775;

/**
 * {@link "https://leetcode.com/problems/global-and-local-inversions/"}
 */
class Solution {
    public boolean isIdealPermutation(int[] A) {
        int global = 0;
        int local = 0;

        for (int i = 0; i < A.length; i++) {
            if (i < A.length - 1 && A[i] > A[i + 1]) {
                local++;
            }
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    global++;
                }
            }
        }
        return global == local;
    }
}