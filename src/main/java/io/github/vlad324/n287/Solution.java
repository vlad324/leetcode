package io.github.vlad324.n287;

/**
 * {@link "https://leetcode.com/problems/find-the-duplicate-number/"}
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int hare = nums[nums[nums[0]]];
        int tortoise = nums[nums[0]];

        while (hare != tortoise) {
            hare = nums[nums[hare]];
            tortoise = nums[tortoise];
        }

        tortoise = nums[0];

        while (hare != tortoise) {
            hare = nums[hare];
            tortoise = nums[tortoise];
        }

        return hare;
    }
}
