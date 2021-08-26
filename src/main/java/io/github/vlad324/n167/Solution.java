package io.github.vlad324.n167;

/**
 * {@link "https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/"}
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        int sum;
        while (l != r) {
            sum = numbers[l] + numbers[r];
            if (sum > target) {
                r--;
            } else if (sum < target) {
                l++;
            } else {
                return new int[]{l + 1, r + 1};
            }
        }

        return new int[0];
    }
}
