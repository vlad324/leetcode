package io.github.vlad324.n3;

import java.util.HashSet;

/**
 * {@link "https://leetcode.com/problems/longest-substring-without-repeating-characters/"}
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }

        int max = 0;
        final var seen = new HashSet<Character>();

        int start = 0;
        int end = 0;
        while (end < s.length()) {
            final var lastChar = s.charAt(end);
            if (seen.contains(lastChar)) {
                seen.remove(s.charAt(start));
                start++;
            } else {
                seen.add(lastChar);
                end++;
                max = Math.max(max, seen.size());
            }
        }

        return max;
    }
}
