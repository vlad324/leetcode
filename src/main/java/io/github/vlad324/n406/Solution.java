package io.github.vlad324.n406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * {@link "https://leetcode.com/problems/queue-reconstruction-by-height/"}
 */
class Solution {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, Comparator.<int[]>comparingInt(a -> a[0])
            .reversed()
            .thenComparingInt(a -> a[1]));
        var tmp = new ArrayList<int[]>();
        for (final int[] person : people) {
            tmp.add(person[1], person);
        }

        int[][] result = new int[people.length][2];
        for (int i = 0; i < tmp.size(); i++) {
            result[i] = tmp.get(i);
        }

        return result;
    }
}
