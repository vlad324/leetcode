package io.github.vlad324.n845;

/**
 * {@link "https://leetcode.com/problems/longest-mountain-in-array/"}
 */
class Solution {
    public int longestMountain(int[] A) {
        int count = 0;
        int start = 0;
        while (start < A.length) {
            int end = start;

            if (end + 1 < A.length && A[end] < A[end + 1]) {
                while (end + 1 < A.length && A[end] < A[end + 1]) {
                    end++;
                }

                if (end + 1 < A.length && A[end] > A[end + 1]) {
                    while (end + 1 < A.length && A[end] > A[end + 1]) {
                        end++;
                    }

                    count = Math.max(count, end - start + 1);
                }
            }

            start = Math.max(end, start + 1);
        }

        return count;
    }
}