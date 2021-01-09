package io.github.vlad324.n127;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/word-ladder/"}
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        final var queue = new LinkedList<String>();
        final var visited = new HashSet<String>();

        queue.add(beginWord);
        visited.add(beginWord);

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                final var word = queue.poll();
                if (endWord.equals(word)) {
                    return level;
                }

                for (final var s : wordList) {
                    if (!visited.contains(s) && differsByOneChar(word, s)) {
                        queue.add(s);
                        visited.add(s);
                    }
                }
            }
        }

        return 0;
    }

    private boolean differsByOneChar(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        boolean diff = false;
        for (int i = 0; i < s1.length(); i++) {
            final var check = s1.charAt(i) != s2.charAt(i);
            if (diff && check) {
                return false;
            }
            diff |= check;
        }

        return diff;
    }
}