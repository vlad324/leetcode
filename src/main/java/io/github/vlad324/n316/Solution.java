package io.github.vlad324.n316;

import java.util.ArrayDeque;

/**
 * {@link "https://leetcode.com/problems/remove-duplicate-letters/"}
 */
class Solution {
    public String removeDuplicateLetters(String s) {
        final var lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        final var deque = new ArrayDeque<Integer>(26);
        final var seen = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            final var c = s.charAt(i) - 'a';

            if (seen[c]) {
                continue;
            }

            while (!deque.isEmpty() && deque.peekLast() > c && i < lastIndex[deque.peekLast()]) {
                seen[deque.pollLast()] = false;
            }

            deque.addLast(c);
            seen[c] = true;
        }

        final var result = new StringBuilder(deque.size());
        while (!deque.isEmpty()) {
            result.append((char) (deque.pop() + 'a'));
        }

        return result.toString();
    }
}
