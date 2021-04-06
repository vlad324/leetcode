package io.github.vlad324.n1551;

/**
 * {@link "https://leetcode.com/problems/minimum-operations-to-make-array-equal/"}
 */
class Solution {
    public int minOperations(int n) {
        int c = 0;
        for (int i = 0; i < n; i++) {
            final var q = n - 2 * i - 1;
            if (q > 0) {
                c += q;
            } else {
                break;
            }
        }

        return c;
    }
}
