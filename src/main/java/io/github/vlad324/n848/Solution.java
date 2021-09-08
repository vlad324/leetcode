package io.github.vlad324.n848;

/**
 * {@link "https://leetcode.com/problems/shifting-letters/"}
 */
class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        final var c = s.toCharArray();
        for (int i = shifts.length - 1; i >= 0; i--) {
            int current = shifts[i] % 26;

            if (current != 0) {
                c[i] = (char) ('a' + (c[i] - 'a' + current) % 26);
            }

            if (i > 0) {
                shifts[i - 1] = shifts[i - 1] % 26 + current;
            }
        }

        return new String(c);
    }
}
