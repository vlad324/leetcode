package io.github.vlad324.n667;

/**
 * {@link "https://leetcode.com/problems/beautiful-arrangement-ii/"}
 */
class Solution {
    public int[] constructArray(int n, int k) {
        final var result = new int[n];
        int c = 0;
        for (int i = 1; i < n - k; i++) {
            result[c++] = i;
        }
        for (int i = 0; i <= k; i++) {
            result[c++] = (i % 2 == 0) ? (n - k + i / 2) : (n - i / 2);
        }

        return result;
    }
}
