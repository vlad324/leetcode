package io.github.vlad324.n522;

import java.util.Arrays;

/**
 * {@link "https://leetcode.com/problems/longest-uncommon-subsequence-ii/"}
 */
class Solution {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (a, b) -> b.length() - a.length());
        for (int i = 0; i < strs.length; i++) {
            boolean isSubsequence = false;
            for (int j = 0; j < strs.length; j++) {
                if (i != j && isSubsequence(strs[i], strs[j])) {
                    isSubsequence = true;
                    break;
                }
            }

            if (!isSubsequence) {
                return strs[i].length();
            }
        }

        return -1;
    }

    private boolean isSubsequence(String a, String b) {
        if (a.length() > b.length()) {
            return false;
        }

        int i = 0;
        for (int j = 0; j < b.length(); j++) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;

                if (i == a.length()) {
                    return true;
                }
            }
        }

        return false;
    }
}
