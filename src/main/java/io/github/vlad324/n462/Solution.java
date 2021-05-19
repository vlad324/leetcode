package io.github.vlad324.n462;

import java.util.Arrays;

/**
 * {@link "https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/"}
 */
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int result = 0;
        while (left < right) {
            result += nums[right] - nums[left];
            right--;
            left++;
        }

        return result;
    }
}