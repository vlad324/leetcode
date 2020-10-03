package io.github.vlad324.n338;

/**
 * {@link "https://leetcode.com/problems/counting-bits"}
 */
class Solution {
    public int[] countBits(int num) {
        final var result = new int[num + 1];

        for (int i = 1; i < result.length; i++) {
            result[i] = result[i & (i - 1)] + 1;
        }

        return result;
    }
}
