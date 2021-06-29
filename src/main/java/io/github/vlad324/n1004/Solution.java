package io.github.vlad324.n1004;

/**
 * {@link "https://leetcode.com/problems/max-consecutive-ones-iii/"}
 */
class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int end = 1;
        int zeroCount = nums[start] == 0 ? 1 : 0;
        int result = 0;
        while (end < nums.length) {
            if (nums[end] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[start] == 0) {
                    zeroCount--;
                }

                start++;
            }

            end++;
            result = Math.max(end - start, result);
        }

        return result;
    }
}
