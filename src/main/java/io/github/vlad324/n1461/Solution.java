package io.github.vlad324.n1461;

import java.util.HashSet;

/**
 * {@link "https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/"}
 */
class Solution {

    public boolean hasAllCodes(String s, int k) {
        final var maxNumber = Math.pow(2, k);
        final var codes = new HashSet<String>();

        for (int i = 0; i < s.length() - k + 1; i++) {
            codes.add(s.substring(i, i + k));

            if (codes.size() == maxNumber) {
                return true;
            }
        }

        return false;
    }
}
