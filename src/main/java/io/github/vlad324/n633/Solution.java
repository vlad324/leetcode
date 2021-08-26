package io.github.vlad324.n633;

/**
 * {@link "https://leetcode.com/problems/sum-of-square-numbers/"}
 */
class Solution {
    public boolean judgeSquareSum(int c) {
        int l = 0;
        int r = (int) Math.sqrt(c);

        while (l <= r) {
            int result = l * l + r * r;

            if (result > c) {
                r--;
            } else if (result < c) {
                l++;
            } else {
                return true;
            }
        }

        return false;
    }
}
