package io.github.vlad324.n342;

/**
 * {@link "https://leetcode.com/problems/power-of-four/"}
 */
class Solution {
    public boolean isPowerOfFour(int num) {
        if (num == 1) {
            return true;
        }

        double n = num;
        while (n >= 4) {
            if (n == 4) {
                return true;
            }
            n /= 4;
        }

        return false;
    }
}
