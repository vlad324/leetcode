package io.github.vlad324.n162;

/**
 * {@link "https://leetcode.com/problems/find-peak-element/"}
 */
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (r + l) / 2;

            if (isPeak(nums, m)) {
                return m;
            }

            if (nums[m] < nums[m + 1]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }

    private boolean isPeak(int[] nums, int m) {
        if (m == 0) {
            return nums[0] > nums[1];
        }

        if (m == nums.length - 1) {
            return nums[m] > nums[m - 1];
        }

        return nums[m - 1] < nums[m] && nums[m] > nums[m + 1];
    }
}
