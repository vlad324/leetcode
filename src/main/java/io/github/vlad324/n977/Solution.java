package io.github.vlad324.n977;

import java.util.Stack;

/**
 * {@link "https://leetcode.com/problems/squares-of-a-sorted-array/"}
 */
class Solution {

    public int[] sortedSquares(int[] A) {
        if (A == null) {
            return new int[0];
        }

        final var stack = new Stack<Integer>();

        int[] result = new int[A.length];
        int pointer = 0;
        for (final int value : A) {
            if (value < 0) {
                stack.push(value * value);
            } else {
                final var n = value * value;
                while (!stack.empty() && n > stack.peek()) {
                    result[pointer++] = stack.pop();
                }
                result[pointer++] = n;
            }
        }

        while (!stack.empty()) {
            result[pointer++] = stack.pop();
        }

        return result;
    }
}
