package io.github.vlad324.n389;

/**
 * {@link "https://leetcode.com/problems/find-the-difference/"}
 */
class Solution {
    public char findTheDifference2(String s, String t) {
        final var chars = new int[26];
        for (int i = 0; i < t.length(); i++) {
            chars[t.charAt(i) - 'a']++;

            if (i < s.length()) {
                chars[s.charAt(i) - 'a']++;
            }
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] % 2 != 0) {
                return (char) (97 + i);
            }
        }

        return ' ';
    }

    public char findTheDifference(String s, String t) {
        int sum = 0;
        final var sa = s.toCharArray();
        final var ta = t.toCharArray();
        for (int i = 0; i < ta.length; i++) {
            sum += ta[i];

            if (i < s.length()) {
                sum -= sa[i];
            }
        }

        return (char) sum;
    }
}