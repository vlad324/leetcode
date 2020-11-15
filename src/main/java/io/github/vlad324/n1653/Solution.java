package io.github.vlad324.n1653;

/**
 * {@link "https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/"}
 */
class Solution {
    public int minimumDeletions(String s) {
        int aCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                aCount++;
            }
        }

        if (aCount == 0 || aCount == s.length()) {
            return 0;
        }

        int result = Integer.MAX_VALUE;
        int bCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {
                result = Math.min(result, bCount + aCount);
                bCount++;
            } else {
                aCount--;
            }
        }

        return Math.min(result, bCount);
    }
}