package io.github.vlad324.n557;

/**
 * {@link "https://leetcode.com/problems/reverse-words-in-a-string-iii/"}
 */
class Solution {
    public String reverseWords(String s) {
        int from = 0;
        final var chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                swap(chars, from, i - 1);
                from = i + 1;
            }
        }

        swap(chars, from, chars.length - 1);

        return new String(chars);
    }

    private void swap(char[] chars, int from, int to) {
        char temp;
        while (from < to) {
            temp = chars[from];
            chars[from] = chars[to];
            chars[to] = temp;

            from++;
            to--;
        }
    }
}