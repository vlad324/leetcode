package io.github.vlad324.n906;

/**
 * {@link "https://leetcode.com/problems/super-palindromes/"}
 */
class Solution {

    private static final int MAGIC = 100000;

    public int superpalindromesInRange(String left, String right) {
        final var L = Long.parseLong(left);
        final var R = Long.parseLong(right);
        int count = 0;

        // count odd length;
        for (int k = 1; k < MAGIC; ++k) {
            final var sb = new StringBuilder(Integer.toString(k));
            for (int i = sb.length() - 2; i >= 0; --i) {
                sb.append(sb.charAt(i));
            }

            long v = Long.parseLong(sb.toString());
            v *= v;
            if (v > R) {
                break;
            }

            if (v >= L && isPalindrome(v)) {
                count++;
            }
        }

        // count even length;
        for (int k = 1; k < MAGIC; ++k) {
            final var sb = new StringBuilder(Integer.toString(k));
            for (int i = sb.length() - 1; i >= 0; --i) {
                sb.append(sb.charAt(i));
            }
            long v = Long.parseLong(sb.toString());
            v *= v;
            if (v > R) {
                break;
            }

            if (v >= L && isPalindrome(v)) {
                count++;
            }
        }

        return count;
    }

    public boolean isPalindrome(long x) {
        return x == reverse(x);
    }

    public long reverse(long x) {
        long ans = 0;
        while (x > 0) {
            ans = 10 * ans + x % 10;
            x /= 10;
        }

        return ans;
    }
}