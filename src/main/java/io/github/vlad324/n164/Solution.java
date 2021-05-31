package io.github.vlad324.n164;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/maximum-gap/"}
 */
class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int hi = 0;
        int lo = Integer.MAX_VALUE;
        for (int n : nums) {
            hi = Math.max(hi, n);
            lo = Math.min(lo, n);
        }

        final var bucketsSize = Math.max((hi - lo) / (nums.length - 1), 1);
        final var buckets = new ArrayList<List<Integer>>();
        for (int i = (hi - lo) / bucketsSize; i >= 0; i--) {
            buckets.add(new ArrayList<>());
        }
        for (int n : nums) {
            buckets.get((n - lo) / bucketsSize).add(n);
        }

        int ans = 0;
        int currhi = 0;
        for (List<Integer> b : buckets) {
            if (b.isEmpty()) {
                continue;
            }

            int prevhi = currhi > 0 ? currhi : b.get(0);
            int currlo = b.get(0);
            for (int n : b) {
                currhi = Math.max(currhi, n);
                currlo = Math.min(currlo, n);
            }

            ans = Math.max(ans, currlo - prevhi);
        }

        return ans;
    }
}
