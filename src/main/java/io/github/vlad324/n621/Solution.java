package io.github.vlad324.n621;

/**
 * {@link "https://leetcode.com/problems/task-scheduler/"}
 */
class Solution {

    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }

        if (n == 0) {
            return tasks.length;
        }

        int[] counts = new int[26];
        for (final char task : tasks) {
            counts[task - 'A']++;
        }

        int max = 0;
        int numberOfMaxElements = 1;
        for (final int count : counts) {
            if (count > max) {
                max = count;
                numberOfMaxElements = 1;
            } else if (count == max) {
                numberOfMaxElements++;
            }
        }

        return Math.max((max - 1) * (n + 1) + numberOfMaxElements, tasks.length);
    }
}
