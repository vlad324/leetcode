package io.github.vlad324.n1283;

/**
 * {@link "https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/"}
 */
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = nums[0];
        for (final int n : nums) {
            max = Math.max(max, n);
        }

        int min = 1;
        while (min <= max) {
            int i = min + (max - min) / 2;

            int sum = 0;
            for (final int num : nums) {
                sum += (num + i - 1) / i;

                if (sum > threshold) {
                    break;
                }
            }

            if (sum > threshold) {
                min = i + 1;
            } else {
                max = i - 1;
            }
        }

        return min;
    }
}