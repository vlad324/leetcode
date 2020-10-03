package io.github.vlad324.n438;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/find-all-anagrams-in-a-string/"}
 */
class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length() || p.chars().anyMatch(c -> s.indexOf((char) c) == -1)) {
            return Collections.emptyList();
        }

        final int patternLength = p.length();
        final int shift = 'a';

        final short[] windowCount = new short[26];
        final short[] patternCount = new short[26];
        for (int i = 0; i < patternLength; i++) {
            windowCount[s.charAt(i) - shift] += 1;
            patternCount[p.charAt(i) - shift] += 1;
        }

        final var result = new LinkedList<Integer>();

        for (int i = patternLength; i < s.length(); i++) {
            if (equals(windowCount, patternCount)) {
                result.add(i - patternLength);
            }

            windowCount[s.charAt(i - patternLength) - shift] -= 1;
            windowCount[s.charAt(i) - shift] += 1;
        }

        if (equals(windowCount, patternCount)) {
            result.add(s.length() - patternLength);
        }

        return result;
    }

    private boolean equals(short[] a, short[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
