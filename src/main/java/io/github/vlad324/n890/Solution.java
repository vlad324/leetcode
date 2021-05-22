package io.github.vlad324.n890;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/find-and-replace-pattern/"}
 */
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        final var result = new ArrayList<String>();

        for (final var word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean matches(String word, String pattern) {
        final var mapping = new HashMap<Character, Character>();
        final var used = new HashSet<Character>();

        for (int i = 0; i < word.length(); i++) {
            final var patterChar = pattern.charAt(i);
            final var wordChar = word.charAt(i);

            if ((mapping.containsKey(patterChar) && mapping.get(patterChar) != wordChar) ||
                (!mapping.containsKey(patterChar) && used.contains(wordChar))) {
                return false;
            }

            used.add(wordChar);
            mapping.put(patterChar, wordChar);
        }

        return true;
    }
}
