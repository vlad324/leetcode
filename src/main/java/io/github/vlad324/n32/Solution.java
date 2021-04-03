package io.github.vlad324.n32;

/**
 * {@link "https://leetcode.com/problems/longest-valid-parentheses/"}
 */
class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        int open = 0;
        int close = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close) {
                max = Math.max(max, open * 2);
            } else if (close > open) {
                close = 0;
                open = 0;
            }
        }

        open = 0;
        close = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close) {
                max = Math.max(max, open * 2);
            } else if (open > close) {
                close = 0;
                open = 0;
            }
        }

        return max;
    }
}