package io.github.vlad324.n238;

/**
 * {@link "https://leetcode.com/problems/product-of-array-except-self/"}
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        final var result = new int[nums.length];
        int zeroCount = 0;
        int k = 1;
        for (final int num : nums) {
            if (num == 0) {
                zeroCount++;

                if (zeroCount > 1) {
                    return result;
                }
            } else {
                k *= num;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                result[i] = k;
            } else if (zeroCount != 0) {
                result[i] = 0;
            } else {
                result[i] = k / nums[i];
            }
        }

        return result;
    }
}
