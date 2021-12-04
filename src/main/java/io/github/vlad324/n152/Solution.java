package io.github.vlad324.n152;

/**
 * {@link "https://leetcode.com/problems/maximum-product-subarray/"}
 */
class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            final var a = max * nums[i];
            final var b = min * nums[i];
            max = Math.max(Math.max(a, b), nums[i]);
            min = Math.min(Math.min(a, b), nums[i]);

            result = Math.max(result, max);
        }

        return result;
    }
}
