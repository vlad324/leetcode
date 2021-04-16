package io.github.vlad324.n1209;

import java.util.ArrayDeque;

/**
 * {@link "https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/"}
 */
class Solution {
    public String removeDuplicates(String s, int k) {
        final var stack = new ArrayDeque<int[]>();
        for (final var c : s.toCharArray()) {
            final var peek = stack.peek();
            if (peek != null && peek[0] == c) {
                if (++peek[1] == k) {
                    stack.pop();
                }
            } else {
                stack.push(new int[]{c, 1});
            }
        }

        final var result = new StringBuilder();
        while (!stack.isEmpty()) {
            final var letter = stack.pollLast();
            for (int j = 0; j < letter[1]; j++) {
                result.appendCodePoint(letter[0]);
            }
        }

        return result.toString();
    }
}
