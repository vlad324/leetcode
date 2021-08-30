package io.github.vlad324.n567;

/**
 * {@link "https://leetcode.com/problems/permutation-in-string/"}
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        final var s1Footprint = new int[26];
        final var s2Footprint = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Footprint[s1.charAt(i) - 'a']++;
            s2Footprint[s2.charAt(i) - 'a']++;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            if (same(s1Footprint, s2Footprint)) {
                return true;
            }

            s2Footprint[s2.charAt(i - s1.length()) - 'a']--;
            s2Footprint[s2.charAt(i) - 'a']++;
        }

        return same(s1Footprint, s2Footprint);
    }

    private boolean same(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }
}