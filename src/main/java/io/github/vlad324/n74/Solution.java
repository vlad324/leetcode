package io.github.vlad324.n74;

import java.util.Arrays;

/**
 * {@link "https://leetcode.com/problems/search-a-2d-matrix/"}
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || target < matrix[0][0]) {
            return false;
        }

        int left = 0;
        int right = matrix.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            final var value = matrix[mid][0];
            if (value == target) {
                return true;
            }

            if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return Arrays.binarySearch(matrix[left - 1], target) > -1;
    }
}
