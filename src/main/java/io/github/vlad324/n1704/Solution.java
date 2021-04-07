package io.github.vlad324.n1704;

/**
 * {@link "https://leetcode.com/problems/determine-if-string-halves-are-alike/"}
 */
class Solution {

    public boolean halvesAreAlike(String s) {
        var c = 0;
        final var chars = s.toCharArray();
        final var mid = chars.length / 2;
        for (int i = 0; i < mid; i++) {
            if (isVowel(chars[i])) {
                c++;
            }

            if (isVowel(chars[mid + i])) {
                c--;
            }
        }

        return c == 0;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
            c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
