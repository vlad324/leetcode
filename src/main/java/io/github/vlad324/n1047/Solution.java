package io.github.vlad324.n1047;

/**
 * {@link "https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/"}
 */
class Solution {
    public String removeDuplicates(String s) {
        final var result = new char[s.length()];
        int i = 0;
        for (final var c : s.toCharArray()) {
            if (i > 0 && result[i - 1] == c) {
                i--;
            } else {
                result[i] = c;
                i++;
            }
        }

        return new String(result, 0, i);
    }
}
