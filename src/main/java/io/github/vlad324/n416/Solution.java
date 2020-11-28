package io.github.vlad324.n416;

/**
 * {@link "https://leetcode.com/problems/partition-equal-subset-sum/"}
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (final int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        return dfs(nums, nums.length, sum / 2, new Boolean[nums.length + 1][sum + 1]);
    }

    private boolean dfs(int[] nums, int i, int sum, Boolean[][] dp) {
        if (sum == 0) {
            return true;
        }

        if (i == 0 || sum < 0) {
            return false;
        }

        if (dp[i][sum] == null) {
            dp[i][sum] = dfs(nums, i - 1, sum - nums[i - 1], dp) || dfs(nums, i - 1, sum, dp);
        }

        return dp[i][sum];
    }
}
