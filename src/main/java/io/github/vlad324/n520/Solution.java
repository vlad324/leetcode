package io.github.vlad324.n520;

/**
 * {@link "https://leetcode.com/problems/detect-capital/"}
 */
class Solution {
    public boolean detectCapitalUse(String word) {
        for (int i = 0; i < word.length() - 1; i++) {
            if ((word.charAt(i) <= 90 && word.charAt(i + 1) >= 97 && i != 0)
                || (word.charAt(i) >= 97 && word.charAt(i + 1) <= 90)) {
                return false;
            }
        }

        return true;
    }
}
