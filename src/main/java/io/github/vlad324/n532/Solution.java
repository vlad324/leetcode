package io.github.vlad324.n532;

import java.util.Arrays;

/**
 * {@link "https://leetcode.com/problems/k-diff-pairs-in-an-array/"}
 */
class Solution {

    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int count = 0;
        int i = 0;
        int j = 1;
        while (i < nums.length && j < nums.length) {
            if (i == j || nums[j] - nums[i] < k) {
                j++;
                continue;
            }

            if (nums[j] - nums[i] > k) {
                i++;
                continue;
            }

            count++;
            i++;
            while (i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
        }

        return count;
    }
}