package io.github.vlad324.n209;

/**
 * {@link "https://leetcode.com/problems/minimum-size-subarray-sum/"}
 */
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];

            while (sum >= target) {
                result = Math.min(result, end - start + 1);
                sum -= nums[start];
                start++;
            }
        }

        return result != Integer.MAX_VALUE ? result : 0;
    }
}
