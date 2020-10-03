package io.github.vlad324.n31;

import java.util.Arrays;

/**
 * {@link "https://leetcode.com/problems/next-permutation/"}
 */
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        boolean reverse = true;
        int index = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] - nums[i - 1] > 0) {
                reverse = false;
                index = i - 1;
                break;
            }
        }

        if (reverse) {
            int i = 0;
            int j = nums.length - 1;
            while (i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        } else {
            int j = -1;
            int min = Integer.MAX_VALUE;
            for (int i = index + 1; i < nums.length; i++) {
                final var diff = nums[i] - nums[index];
                if (diff > 0 && diff < min) {
                    j = i;
                }
            }

            swap(nums, index, j);
            Arrays.sort(nums, index + 1, nums.length);
        }
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}