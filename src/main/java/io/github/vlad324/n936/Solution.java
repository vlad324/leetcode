package io.github.vlad324.n936;

import java.util.Stack;

/**
 * {@link "https://leetcode.com/problems/stamping-the-sequence/"}
 */
class Solution {
    public int[] movesToStamp(String stamp, String target) {
        final var stampArray = stamp.toCharArray();
        final var targetArray = target.toCharArray();
        final var visited = new boolean[target.length()];
        final var stack = new Stack<Integer>();
        int replacedCount = 0;

        while (replacedCount != target.length()) {
            int stackSize = stack.size();
            for (int i = 0; i <= targetArray.length - stampArray.length; i++) {
                if (!visited[i] && canReplace(i, stampArray, targetArray)) {
                    replacedCount += replace(i, stampArray, targetArray);
                    stack.push(i);
                    visited[i] = true;
                    if (replacedCount == targetArray.length) {
                        break;
                    }
                }
            }

            if (stackSize == stack.size()) {
                return new int[0];
            }
        }

        final var result = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i] = stack.pop();
            i++;
        }

        return result;
    }

    private int replace(int i, char[] stampArray, char[] targetArray) {
        int count = 0;
        for (int j = 0; j < stampArray.length; j++) {
            if (targetArray[i + j] != '*') {
                targetArray[i + j] = '*';
                count++;
            }
        }

        return count;
    }

    private boolean canReplace(int i, char[] stampArray, char[] targetArray) {
        for (int j = 0; j < stampArray.length; j++) {
            if (targetArray[i + j] != '*' && targetArray[i + j] != stampArray[j]) {
                return false;
            }
        }

        return true;
    }
}