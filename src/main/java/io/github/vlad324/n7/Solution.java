package io.github.vlad324.n7;

/**
 * {@link "https://leetcode.com/problems/reverse-integer/"}
 */
class Solution {
    public int reverse(int x) {
        final var sb = new StringBuilder(String.valueOf(x)).reverse();
        if (x < 0) {
            return parseIntOrZero(sb.deleteCharAt(sb.length() - 1)
                .insert(0, '-')
                .toString());
        }

        return parseIntOrZero(sb.toString());
    }

    private int parseIntOrZero(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
