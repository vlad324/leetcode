package io.github.vlad324.n696;

/**
 * {@link "https://leetcode.com/problems/count-binary-substrings/"}
 */
class Solution {
    public int countBinarySubstrings(String s) {
        int result = 0;
        int previous = 0;
        int current = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                result += Math.min(previous, current);
                previous = current;
                current = 1;
            } else {
                current++;
            }
        }

        return result + Math.min(previous, current);
    }
}
