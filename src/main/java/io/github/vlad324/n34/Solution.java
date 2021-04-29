package io.github.vlad324.n34;

/**
 * {@link "https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/"}
 */
class Solution {

    private static final int[] NOT_FOUND = {-1, -1};

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return NOT_FOUND;
        }

        int i = 0;
        int j = nums.length - 1;
        int mid;
        while (i <= j) {
            mid = i + (j - i) / 2;

            if (nums[mid] > target) {
                j = mid - 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                final var result = new int[2];
                result[0] = find(nums, target, mid, true);
                result[1] = find(nums, target, mid, false);
                return result;
            }
        }

        return NOT_FOUND;
    }

    private int find(int[] nums, int target, int mid, boolean start) {
        int i = start ? 0 : mid;
        int j = start ? mid : nums.length - 1;

        while (i <= j) {
            mid = i + (j - i) / 2;

            if (nums[mid] > target) {
                j = mid - 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                if (start) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            }
        }

        return start ? i : j;
    }
}
