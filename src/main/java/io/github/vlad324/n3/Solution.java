package io.github.vlad324.n3;

/**
 * {@link "https://leetcode.com/problems/longest-substring-without-repeating-characters/"}
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;

        int i = 0;
        int j = 0;
        final var seen = new boolean[127];
        while (j < s.length()) {
            final var c = s.charAt(j);
            if (seen[c]) {
                seen[s.charAt(i)] = false;
                i++;
            } else {
                seen[c] = true;
                j++;
                max = Math.max(max, j - i);
            }
        }

        return max;
    }
}
