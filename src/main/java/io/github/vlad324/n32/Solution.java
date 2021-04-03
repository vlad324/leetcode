package io.github.vlad324.n32;

/**
 * {@link "https://leetcode.com/problems/longest-valid-parentheses/"}
 */
class Solution {
    public int longestValidParentheses(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j += 2) {
                if (isValid(s, i, j)) {
                    result = Math.max(result, j - i);
                }
            }
        }

        return result;
    }

    private boolean isValid(String s, int i, int j) {
        int openCount = 0;
        for (int k = i; k < j; k++) {
            if (s.charAt(k) == '(') {
                openCount++;
            } else if (openCount != 0) {
                openCount--;
            } else {
                return false;
            }
        }

        return openCount == 0;
    }
}