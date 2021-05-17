package io.github.vlad324.n1048;

import java.util.Arrays;
import java.util.HashMap;

/**
 * {@link "https://leetcode.com/problems/longest-string-chain/"}
 */
class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> b.length() - a.length());

        final var lengths = new HashMap<Integer, Integer>();
        int result = 0;
        final var counts = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            lengths.putIfAbsent(words[i].length(), i);
            for (int j = lengths.getOrDefault(words[i].length() + 1, i); words[j].length() > words[i].length(); j++) {
                if (isPredecessor(words[i], words[j])) {
                    counts[i] = Math.max(counts[i], counts[j] + 1);
                }
            }
            result = Math.max(result, counts[i]);
        }

        return result + 1;
    }

    private boolean isPredecessor(String word1, String word2) {
        if (word1.length() + 1 != word2.length()) {
            return false;
        }

        int diff = 0, i = 0, j = 0;
        while (i < word1.length()) {
            if (word1.charAt(i) == word2.charAt(j)) {
                i++;
            } else {
                if (++diff > 1) {
                    return false;
                }
            }
            j++;
        }

        return true;
    }
}
