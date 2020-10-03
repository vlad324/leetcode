package io.github.vlad324.n334;

/**
 * {@link "https://leetcode.com/problems/reverse-string/"}
 */
class Solution {
    public void reverseString(char[] s) {
        if (s == null || s.length < 2) {
            return;
        }

        for (int i = 0; i < s.length; i++) {
            final var j = s.length - i - 1;

            if (j <= i) {
                return;
            }

            final var temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}
