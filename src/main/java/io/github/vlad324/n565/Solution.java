package io.github.vlad324.n565;

/**
 * {@link "https://leetcode.com/problems/array-nesting/"}
 */
class Solution {

    public int arrayNesting(int[] nums) {
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) {
                continue;
            }

            int temp;
            int j = i;
            int count = 0;
            while (nums[j] != -1) {
                count++;

                temp = nums[j];
                nums[j] = -1;
                j = temp;
            }

            max = Math.max(max, count);
        }

        return max;
    }
}

