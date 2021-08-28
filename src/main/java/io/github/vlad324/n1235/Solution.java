package io.github.vlad324.n1235;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * {@link "https://leetcode.com/problems/maximum-profit-in-job-scheduling/"}
 */
class Solution {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        final var n = startTime.length;
        final var jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);

        final var dp = new TreeMap<Integer, Integer>();
        dp.put(0, 0);

        for (int[] job : jobs) {
            int currentProfit = job[2] + dp.floorEntry(job[0]).getValue();
            if (currentProfit > dp.lastEntry().getValue()) {
                dp.put(job[1], currentProfit);
            }
        }

        return dp.lastEntry().getValue();
    }

    public int jobSchedulingByStartTime(int[] startTime, int[] endTime, int[] profit) {
        final var n = startTime.length;
        final var jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, (a, b) -> b[0] - a[0]);

        final var dp = new TreeMap<Integer, Integer>();
        dp.put(Integer.MAX_VALUE, 0);

        for (int[] job : jobs) {
            int currentProfit = job[2] + dp.ceilingEntry(job[1]).getValue();
            if (currentProfit > dp.firstEntry().getValue()) {
                dp.put(job[0], currentProfit);
            }
        }

        return dp.firstEntry().getValue();
    }
}
