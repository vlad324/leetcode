package io.github.vlad324.n804;

import java.util.HashSet;

/**
 * {@link "https://leetcode.com/problems/unique-morse-code-words/"}
 */
class Solution {

    private static final String[] CODES = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
        ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
        "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }

        final var result = new HashSet<String>();
        for (final String word : words) {
            final var morse = new StringBuilder();
            for (int j = 0; j < word.length(); j++) {
                morse.append(CODES[word.charAt(j) - 'a']);
            }
            result.add(morse.toString());
        }

        return result.size();
    }
}
