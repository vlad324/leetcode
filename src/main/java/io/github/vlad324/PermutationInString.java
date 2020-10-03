package io.github.vlad324;

/**
 * {@link "https://leetcode.com/problems/permutation-in-string/"}
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        final var patterLength = s1.length();
        final int shift = 'a';

        short[] patternCount = new short[26];
        short[] windowCount = new short[26];

        for (int i = 0; i < patterLength; i++) {
            patternCount[s1.charAt(i) - shift] += 1;
            windowCount[s2.charAt(i) - shift] += 1;
        }

        for (int i = patterLength; i < s2.length(); i++) {
            if (equals(patternCount, windowCount)) {
                return true;
            }

            windowCount[s2.charAt(i - patterLength) - shift] -= 1;
            windowCount[s2.charAt(i) - shift] += 1;
        }

        return equals(patternCount, windowCount);
    }

    private boolean equals(short[] a, short[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
