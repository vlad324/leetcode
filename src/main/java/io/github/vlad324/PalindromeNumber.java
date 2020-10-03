package io.github.vlad324;

/**
 * {@link "https://leetcode.com/problems/palindrome-number/"}
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        final int initialValue = x;
        int reversed = 0;
        while (x != 0) {
            final int part = x % 10;
            x /= 10;
            reversed = reversed * 10 + part;

            if (reversed < 0) {
                return false;
            }
        }

        return initialValue == reversed;
    }
}
