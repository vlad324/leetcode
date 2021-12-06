package io.github.vlad324.n5;

/**
 * {@link "https://leetcode.com/problems/longest-palindromic-substring/"}
 */
class Solution {
    public String longestPalindrome(String s) {
        var max = "";
        final var chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            var s1 = max(i, i, chars);
            if (s1.length() > max.length()) {
                max = s1;
            }

            var s2 = max(i, i + 1, chars);
            if (s2.length() > max.length()) {
                max = s2;
            }
        }

        return max;
    }

    private String max(int i, int j, char[] s) {
        if (i < 0 || j >= s.length || s[i] != s[j]) {
            return "";
        }

        int start = i;
        int end = j;
        while (i >= 0 && j < s.length && s[i] == s[j]) {
            start = i;
            end = j;

            i--;
            j++;
        }

        return new String(s, start, end - start + 1);
    }
}
