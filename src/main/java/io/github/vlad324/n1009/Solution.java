package io.github.vlad324.n1009;

/**
 * {@link "https://leetcode.com/problems/complement-of-base-10-integer/"}
 */
class Solution {
    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }

        return (-1 >>> Integer.numberOfLeadingZeros(N)) - N;
    }
}
