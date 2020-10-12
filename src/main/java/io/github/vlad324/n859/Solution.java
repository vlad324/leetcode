package io.github.vlad324.n859;

/**
 * {@link "https://leetcode.com/problems/buddy-strings/"}
 */
class Solution {

    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        int[] aChars = new int[26];
        int[] bChars = new int[26];
        int diffCount = 0;
        for (int i = 0; i < A.length(); i++) {
            final var ai = A.charAt(i) - 'a';
            final var bi = B.charAt(i) - 'a';
            if (ai != bi) {
                diffCount++;
            }

            aChars[ai]++;
            bChars[bi]++;
        }

        boolean hasRepeating = false;
        for (int i = 0; i < aChars.length; i++) {
            if (aChars[i] != bChars[i]) {
                return false;
            }

            if (!hasRepeating && aChars[i] > 1) {
                hasRepeating = true;
            }
        }

        return diffCount == 2 || (diffCount == 0 && hasRepeating);
    }
}
