package io.github.vlad324.n540;

/**
 * {@link "https://leetcode.com/problems/single-element-in-a-sorted-array/"}
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;

            if (nums[m] == nums[m + 1]) {
                m = m - 1;
            }

            if ((m - l + 1) % 2 != 0) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return nums[l];
    }
}
