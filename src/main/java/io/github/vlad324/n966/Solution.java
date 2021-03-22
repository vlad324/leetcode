package io.github.vlad324.n966;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * {@link "https://leetcode.com/problems/vowel-spellchecker/"}
 */
class Solution {
    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    public String[] spellchecker(String[] wordlist, String[] queries) {
        final var set = new HashSet<String>();
        final var map = new HashMap<String, String>();
        for (final var w : wordlist) {
            set.add(w);

            final var lw = w.toLowerCase();
            map.putIfAbsent(lw, w);

            map.putIfAbsent(maskVowels(lw), w);
        }

        final var result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (set.contains(queries[i])) {
                result[i] = queries[i];
                continue;
            }


            final var lq = queries[i].toLowerCase();
            var r = map.get(lq);
            if (r == null) {
                r = map.getOrDefault(maskVowels(lq), "");
            }
            result[i] = r;
        }

        return result;
    }

    private String maskVowels(String w) {
        final var result = new StringBuilder(w.length());
        for (int i = 0; i < w.length(); i++) {
            final var c = w.charAt(i);
            if (VOWELS.contains(c)) {
                result.append('*');
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}