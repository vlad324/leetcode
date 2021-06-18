package io.github.vlad324.n795;

/**
 * {@link "https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/"}
 */
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        left = left - 1;

        int c1 = 0;
        int c2 = 0;
        int result = 0;
        for (final int num : nums) {
            if (num <= right) {
                c1++;
            } else {
                c1 = 0;
            }

            if (num <= left) {
                c2++;
            } else {
                c2 = 0;
            }

            result += c1 - c2;
        }

        return result;
    }
}

