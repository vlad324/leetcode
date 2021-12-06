package io.github.vlad324.n413;

/**
 * {@link "https://leetcode.com/problems/arithmetic-slices/"}
 */
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }

        int result = 0;
        int startIndex = 0;
        int endIndex = 1;
        int delta = nums[endIndex] - nums[startIndex];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[endIndex] != delta) {
                startIndex = endIndex;
                endIndex = i;
                delta = nums[endIndex] - nums[startIndex];
            } else {
                endIndex++;
                result += (endIndex - startIndex - 1);
            }
        }

        return result;
    }
}