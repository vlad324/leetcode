package io.github.vlad324.n630;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * {@link "https://leetcode.com/problems/course-schedule-iii/"}
 */
class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        int time = 0;
        final var queue = new PriorityQueue<Integer>((a, b) -> b - a);
        for (final int[] course : courses) {
            if (time + course[0] <= course[1]) {
                time += course[0];
                queue.add(course[0]);
            } else if (!queue.isEmpty() && course[0] < queue.peek()) {
                time += course[0] - queue.poll();
                queue.add(course[0]);
            }
        }

        return queue.size();
    }
}
