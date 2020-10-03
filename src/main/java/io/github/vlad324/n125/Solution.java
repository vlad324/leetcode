package io.github.vlad324.n125;

/**
 * {@link "https://leetcode.com/problems/valid-palindrome/"}
 */
class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            final var ci = s.charAt(i);
            final var cj = s.charAt(j);

            final var ciType = getType(ci);
            final var cjType = getType(cj);

            if (ciType == 0) {
                i++;
                continue;
            }

            if (cjType == 0) {
                j--;
                continue;
            }

            final var diff = ci - cj;
            if (diff != 0 && (ciType != 1 || cjType != 1 || (diff != 32 && diff != -32))) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    private int getType(char c) {
        if (isLetter(c)) {
            return 1;
        }

        if (isNumber(c)) {
            return 2;
        }

        return 0;
    }

    private boolean isLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}