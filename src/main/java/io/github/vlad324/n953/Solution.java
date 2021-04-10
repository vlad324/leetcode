package io.github.vlad324.n953;

/**
 * {@link "https://leetcode.com/problems/verifying-an-alien-dictionary/"}
 */
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        final var orderMap = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderMap[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (greater(words[i], words[i + 1], orderMap)) {
                return false;
            }
        }

        return true;
    }

    private boolean greater(String w1, String w2, int[] order) {
        int i = 0;
        while (i < w1.length() && i < w2.length()) {
            final var c1 = w1.charAt(i) - 'a';
            final var c2 = w2.charAt(i) - 'a';
            if (c1 != c2) {
                return order[c1] > order[c2];
            }
            i++;
        }

        return i < w1.length();
    }
}
