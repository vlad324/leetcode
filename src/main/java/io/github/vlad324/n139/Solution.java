package io.github.vlad324.n139;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/word-break/"}
 */
class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        final var dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (final var w : wordDict) {
                int start = i - w.length();

                if (start >= 0 && dp[start] && !dp[i] && matches(start, s, w)) {
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];
    }

    private boolean matches(int start, String s, String w) {
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) != s.charAt(start + i)) {
                return false;
            }
        }

        return true;
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        final var dictionary = new HashSet<>(wordDict);

        final var visited = new boolean[s.length()];

        final var queue = new LinkedList<Integer>();
        queue.add(0);

        while (!queue.isEmpty()) {
            final var start = queue.poll();

            if (!visited[start]) {
                visited[start] = true;

                for (int end = start + 1; end <= s.length(); end++) {
                    if (dictionary.contains(s.substring(start, end))) {
                        if (end == s.length()) {
                            return true;
                        }

                        queue.add(end);
                    }
                }
            }
        }

        return false;
    }
}