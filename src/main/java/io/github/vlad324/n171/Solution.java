package io.github.vlad324.n171;

/**
 * {@link "https://leetcode.com/problems/excel-sheet-column-number/"}
 */
class Solution {
    public int titleToNumber(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            result = result * 26 + s.charAt(i) - 'A' + 1;
        }

        return result;
    }

    // A - 1 - 26
    // AA - 27 - 702
}