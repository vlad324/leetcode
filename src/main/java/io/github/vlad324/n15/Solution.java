package io.github.vlad324.n15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/3sum/"}
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        final var result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            int x = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                int y = nums[j];

                int k = find(nums, -(x + y), j + 1);
                if (k > -1) {
                    result.add(List.of(x, y, nums[k]));
                }
            }
        }

        return result;
    }

    private int find(int[] nums, int value, int fromIndex) {
        return Arrays.binarySearch(nums, fromIndex, nums.length, value);
    }
}
