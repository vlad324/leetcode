package io.github.vlad324.n55;

import java.util.HashSet;
import java.util.Set;

/**
 * {@link "https://leetcode.com/problems/jump-game/"}
 */
class Solution {
    public boolean canJump(int[] nums) {
        return canJump(0, nums, new HashSet<>());
    }

    public boolean canJump(int i, int[] nums, Set<Integer> visited) {
        if (visited.contains(i)) {
            return false;
        } else if (i == nums.length - 1) {
            return true;
        } else if (i >= nums.length) {
            return false;
        }

        for (int j = nums[i]; j > 0; j--) {
            if (canJump(i + j, nums, visited)) {
                return true;
            }
        }

        visited.add(i);

        return false;
    }
}
