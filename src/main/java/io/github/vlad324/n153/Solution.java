package io.github.vlad324.n153;

/**
 * {@link "https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/"}
 */
class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        if (nums[l] <= nums[r]) {
            return nums[0];
        }

        while (l < r) {
            int m = l + (r - l) / 2;

            if (nums[m] > nums[m + 1]) {
                return nums[m + 1];
            }
            if (nums[m] < nums[m - 1]) {
                return nums[m];
            }

            if (nums[m] < nums[r]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return -1;
    }
}
