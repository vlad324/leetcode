package io.github.vlad324.n1074;

import java.util.HashMap;

/**
 * {@link "https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/"}
 */
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int k) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] += matrix[i - 1][j];
            }
        }

        int count = 0;
        final var map = new HashMap<Integer, Integer>();
        for (int start = 0; start < matrix.length; start++) {
            for (int i = start; i < matrix.length; i++) {
                map.clear();
                map.put(0, 1);

                int prefixsum = 0;
                for (int j = 0; j < matrix[0].length; j++) {
                    prefixsum += matrix[i][j] - (start != 0 ? matrix[start - 1][j] : 0);
                    count += map.getOrDefault(prefixsum - k, 0);
                    map.put(prefixsum, map.getOrDefault(prefixsum, 0) + 1);
                }
            }
        }

        return count;
    }
}
