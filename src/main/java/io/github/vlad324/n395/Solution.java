package io.github.vlad324.n395;

/**
 * {@link "https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/"}
 */
public class Solution {
    public int longestSubstring(String s, int k) {
        int result = 0;
        int maxUnique = countUniqueLetters(s);
        for (int currUnique = 1; currUnique <= maxUnique; currUnique++) {
            final var counts = new int[26];

            int windowStart = 0;
            int windowEnd = 0;

            int unique = 0;
            int countAtLeastK = 0;
            while (windowEnd < s.length()) {
                if (unique <= currUnique) {
                    int idx = s.charAt(windowEnd) - 'a';
                    if (counts[idx] == 0) {
                        unique++;
                    }
                    counts[idx]++;
                    if (counts[idx] == k) {
                        countAtLeastK++;
                    }
                    windowEnd++;
                } else {
                    int idx = s.charAt(windowStart) - 'a';
                    if (counts[idx] == k) {
                        countAtLeastK--;
                    }
                    counts[idx]--;
                    if (counts[idx] == 0) {
                        unique--;
                    }
                    windowStart++;
                }

                if (unique == currUnique && unique == countAtLeastK) {
                    result = Math.max(windowEnd - windowStart, result);
                }
            }
        }

        return result;
    }

    private int countUniqueLetters(String s) {
        final var seen = new boolean[26];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            final var j = s.charAt(i) - 'a';
            if (!seen[j]) {
                count++;
                seen[j] = true;
            }
        }

        return count;
    }
}
