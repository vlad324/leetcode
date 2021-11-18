package io.github.vlad324.n448;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/"}
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == (i + 1)) {
                i++;
                continue;
            }

            int j = nums[i] - 1;
            if (nums[j] == nums[i]) {
                i++;
                continue;
            }

            swap(nums, i, j);
        }

        final var result = new ArrayList<Integer>();
        i = 0;
        while (i < nums.length) {
            final var expected = i + 1;
            if (nums[i] != expected) {
                result.add(expected);
            }
            i++;
        }

        return result;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
