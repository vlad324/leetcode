package io.github.vlad324.n1551;

/**
 * {@link "https://leetcode.com/problems/minimum-operations-to-make-array-equal/"}
 */
class Solution {
    public int minOperations(int n) {
        if (n % 2 == 1) {
            int N = (n - 1) / 2;
            return N * (N + 1);
        }

        int N = n / 2;
        return N * N;
    }
}
