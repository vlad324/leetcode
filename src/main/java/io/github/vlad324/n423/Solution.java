package io.github.vlad324.n423;

/**
 * {@link "https://leetcode.com/problems/reconstruct-original-digits-from-english/"}
 */
class Solution {

    public String originalDigits(String s) {
        final var counts = new int[26];
        for (final var c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        final var digits = new int[10];
        digits[0] = counts['z' - 'a'];
        digits[2] = counts['w' - 'a'];
        digits[4] = counts['u' - 'a'];
        digits[6] = counts['x' - 'a'];
        digits[8] = counts['g' - 'a'];
        digits[1] = counts['o' - 'a'] - digits[0] - digits[2] - digits[4];
        digits[3] = counts['t' - 'a'] - digits[8] - digits[2];
        digits[5] = counts['f' - 'a'] - digits[4];
        digits[7] = counts['s' - 'a'] - digits[6];
        digits[9] = counts['i' - 'a'] - digits[5] - digits[6] - digits[8];

        final var result = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            var f = digits[i];
            while (f > 0) {
                result.append(i);
                f--;
            }
        }

        return result.toString();
    }
}

