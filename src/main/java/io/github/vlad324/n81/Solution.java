package io.github.vlad324.n81;

import java.util.Arrays;

/**
 * {@link "https://leetcode.com/problems/search-in-rotated-sorted-array-ii/"}
 */
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        if (nums.length == 1) {
            return nums[0] == target;
        }

        if (nums[0] < nums[nums.length - 1]) {
            return Arrays.binarySearch(nums, target) >= 0;
        }

        int i = 0;
        int j = nums.length - 1;
        int rotation = -1;
        while (i <= j) {
            if (nums[i] > nums[i + 1]) {
                rotation = i + 1;
                break;
            } else if (nums[j] < nums[j - 1]) {
                rotation = j;
                break;
            }
            i++;
            j--;
        }

        if (rotation == -1) {
            return nums[0] == target;
        }

        if (target <= nums[nums.length - 1]) {
            return Arrays.binarySearch(nums, rotation, nums.length, target) >= 0;
        } else {
            return Arrays.binarySearch(nums, 0, rotation, target) >= 0;
        }
    }
}
