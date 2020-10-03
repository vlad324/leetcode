package io.github.vlad324.n392;

/**
 * {@link "https://leetcode.com/problems/is-subsequence/"}
 */
class Solution {

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }

        final var sLength = s.length();
        final var tLength = t.length();

        int j = 0;
        for (int i = 0; i < tLength; i++) {
            if (t.charAt(i) == s.charAt(j)) {
                j++;
            }

            if (j == sLength) {
                return true;
            }
        }

        return false;
    }
}
