package io.github.vlad324.n978;

/**
 * {@link "https://leetcode.com/problems/longest-turbulent-subarray/"}
 */
class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int ans = 1;
        int trend = 0; // 0 - no, 1 - up, -1 - down
        int start = 0;
        for (int i = 1; i < arr.length; i++) {
            int currentTrend = arr[i] - arr[i - 1];
            if (currentTrend == 0) {
                start = i;
            } else if ((currentTrend ^ trend) >= 0) { // current and previous have the same direction
                start = i - 1;
            }
            trend = currentTrend;

            ans = Math.max(ans, i - start + 1);
        }

        return ans;
    }
}
