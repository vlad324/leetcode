package io.github.vlad324.n231;

/**
 * {@link "https://leetcode.com/problems/power-of-two/"}
 */
class Solution {

    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }

        boolean found = false;
        for (int i = 1; i < n; i = i << 1) {
            boolean current = (n & i) > 0;
            if (found && current) {
                return false;
            }
            found = found || current;
        }

        return true;
    }
}
