package io.github.vlad324.n326;

/**
 * {@link "https://leetcode.com/problems/power-of-three/"}
 */
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 3) {
            return n == 1;
        }

        if (n % 3 != 0) {
            return false;
        }

        return isPowerOfThree(n / 3);
    }
}
