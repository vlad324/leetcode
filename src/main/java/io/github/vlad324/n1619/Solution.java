package io.github.vlad324.n1619;

import java.util.Arrays;

/**
 * {@link "https://leetcode.com/problems/mean-of-array-after-removing-some-elements/"}
 */
class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);

        final var v = arr.length / 20;

        double sum = 0;
        for (int i = v; i < arr.length - v; i++) {
            sum += arr[i];
        }

        return sum / (arr.length - v - v);
    }
}
